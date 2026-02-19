package com.ericbastos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericbastos.workshopmongo.domain.Post;
import com.ericbastos.workshopmongo.repository.PostRepository;
import com.ericbastos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostServices {
	
	@Autowired
	private PostRepository repo;
	
	public Post FindByld(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}
    
	public List<Post> FindByTitle(String text){
		return repo.FindByTitleContaining(text);
	}
}
