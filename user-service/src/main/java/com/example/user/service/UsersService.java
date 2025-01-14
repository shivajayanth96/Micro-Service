package com.example.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.Hotel;
import com.example.user.entity.Rating;
import com.example.user.entity.Users;
import com.example.user.exception.ResourceNotFoundException;
import com.example.user.external.service.HotelService;
import com.example.user.external.service.RatingService;
import com.example.user.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    public Users save(Users users) {
        // generate unique userid
        String randomUserId = UUID.randomUUID().toString();
        users.setUserId(randomUserId);

        return usersRepository.save(users);
    }

    public Users getUserById(String userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    public List<Users> getAllUsers() {
        List<Users> allUsers = usersRepository.findAll();
        allUsers.stream().forEach(user -> {
            List<Rating> ratings = ratingService.getRatingsByUserId(user.getUserId());
            user.setRatings(ratings);

            ratings.stream().forEach(rating -> {
                Hotel hotel = hotelService.getHotelInfo(rating.getHotelId());
                rating.setHotel(hotel);
            });

        });

        return allUsers;
    }

}
