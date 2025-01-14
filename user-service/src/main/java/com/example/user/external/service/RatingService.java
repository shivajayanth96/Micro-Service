package com.example.user.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.user.entity.Rating;

@FeignClient(name = "rating-service")
public interface RatingService {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable String userId);

}
