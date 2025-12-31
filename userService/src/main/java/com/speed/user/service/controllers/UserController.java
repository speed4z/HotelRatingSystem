package com.speed.user.service.controllers;

import com.speed.user.service.entities.User;
import com.speed.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    int retryCount=1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        logger.info("Get Single User Handler: userController");
        logger.info("Retry Count : {}",retryCount++);
        User user1 = userService.getUser(userId);
        return ResponseEntity.ok(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    //Fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
        logger.info("Fallback is executed because service is down : " + ex.getMessage());
        User user =User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("Dummy user created in fallback method")
                .userId("000")
                .build();
        return  new ResponseEntity<>(user,HttpStatus.BAD_REQUEST);
    }

}
