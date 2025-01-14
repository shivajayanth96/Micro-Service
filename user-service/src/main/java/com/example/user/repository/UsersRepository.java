package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
