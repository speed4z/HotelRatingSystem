package com.speed.user.service.services.impl;

import com.speed.user.service.entities.Hotel;
import com.speed.user.service.entities.Rating;
import com.speed.user.service.entities.User;
import com.speed.user.service.exeptions.ResourceNotFoundException;
import com.speed.user.service.external.service.HotelService;
import com.speed.user.service.repositories.UserRepository;
import com.speed.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //Generate unique ID for user
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given ID not found !"));
       //Fetch rating list of user from rating-service
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);

        logger.info("User :"+user);

        if(null != ratingsOfUser){
            List<Rating> ratingList =  Arrays.stream(ratingsOfUser).toList().stream()
                    .peek(rating -> {
                        //restTemplate API call to call Hotel details from hotel id
//                        ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(),Hotel.class);
//                        Hotel hotel = entity.getBody();
//                        logger.info("response Status for Hotel : {} ",entity.getStatusCode());

                        //USING Feign Client for hotel service
                        Hotel hotel = hotelService.getHotel(rating.getHotelId());

                        rating.setHotel(hotel);
                    }).collect(Collectors.toList());

            user.setRatings(ratingList);
        }

        return user;
    }

    @Override
    public User deleteUser(String userId) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
