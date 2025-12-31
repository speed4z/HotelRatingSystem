package com.speed.rating.repositories;

import com.speed.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    //Custom finder methods for User and Hotels queries

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
