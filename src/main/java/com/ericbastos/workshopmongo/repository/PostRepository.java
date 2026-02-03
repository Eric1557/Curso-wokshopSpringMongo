package com.ericbastos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ericbastos.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
