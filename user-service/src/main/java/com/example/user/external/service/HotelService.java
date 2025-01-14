package com.example.user.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.user.entity.Hotel;

@FeignClient(name = "hotel-service")
public interface HotelService {

    @GetMapping("/hotels/get/{hotelId}")
    public Hotel getHotelInfo(@PathVariable String hotelId);

}
