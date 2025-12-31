package com.speed.rating.services.impl;

import com.speed.rating.entities.Rating;
import com.speed.rating.exeptions.ResourceNotFoundException;
import com.speed.rating.repositories.RatingRepository;
import com.speed.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Given Rating Id Not found !!!"));
    }


    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userID) {
        return ratingRepository.findByUserId(userID);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelID) {
        return ratingRepository.findByHotelId(hotelID);
    }
}
