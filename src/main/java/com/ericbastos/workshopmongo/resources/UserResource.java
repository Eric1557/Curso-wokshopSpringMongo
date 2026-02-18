package com.ericbastos.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericbastos.workshopmongo.domain.Post;
import com.ericbastos.workshopmongo.services.PostServices;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	
	@Autowired
	private PostServices services;
	
  public ResponseEntity<Post> FindByld(@PathVariable String id){
	  Post obj = services.FindByld(id);
	  return ResponseEntity.ok().body(obj);
  }
	
	
 
}
