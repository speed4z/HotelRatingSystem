package com.speed.rating.controllers;

import com.speed.rating.entities.Rating;
import com.speed.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.addRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }


    @GetMapping("{ratingId}")
    public ResponseEntity<Rating> getById(@PathVariable String ratingId){
        return ResponseEntity.ok(ratingService.getRatingById(ratingId));
    }


    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

}
