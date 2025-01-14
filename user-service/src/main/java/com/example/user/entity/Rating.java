package com.example.user.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}