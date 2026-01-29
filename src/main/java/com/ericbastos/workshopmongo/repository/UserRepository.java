package com.ericbastos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ericbastos.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
