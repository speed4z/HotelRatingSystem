package com.speed.rating.services;

import com.speed.rating.RatingServiceApplication;
import com.speed.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating addRating(Rating rating);

    Rating getRatingById(String ratingId);

    List<Rating> getAllRatings();

    //Get all rating by userId
    List<Rating> getRatingsByUserId(String userID);

    //Get all ratings for hotelId
    List<Rating> getRatingsByHotelId(String hotelID);
}
