package com.example.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entity.Rating;
import com.example.rating.repository.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repository;

    public Rating create(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return repository.save(rating);
    }

    public List<Rating> getRatings() {
        return repository.findAll();
    }

    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }

}
