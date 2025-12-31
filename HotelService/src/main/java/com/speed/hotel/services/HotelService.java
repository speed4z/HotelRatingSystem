package com.speed.hotel.services;

import com.speed.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);

}
