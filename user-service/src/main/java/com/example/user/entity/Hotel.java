package com.example.user.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String location;
    private String about;

}
