package com.ericbastos.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ericbastos.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{'title': { $regex: ?0, $options: 'i' } }")
	List<Post> serchTitle(String text);
	
	
	List<Post>FindByTitleContainingIgnoreCase(String text);

}
