package com.example.rating.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ratings")
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String ratingId;

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
