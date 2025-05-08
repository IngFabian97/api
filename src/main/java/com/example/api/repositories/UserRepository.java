package com.example.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.api.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
}
