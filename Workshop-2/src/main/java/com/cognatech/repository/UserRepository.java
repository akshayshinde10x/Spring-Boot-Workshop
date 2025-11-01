package com.cognatech.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognatech.entity.Users;


@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);  //select * from users where email=?
}