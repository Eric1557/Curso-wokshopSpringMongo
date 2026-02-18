package com.ericbastos.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ericbastos.workshopmongo.domain.Post;
import com.ericbastos.workshopmongo.services.PostServices;

@RestController
@RequestMapping("/users")
public class PostResource {
	
	@Autowired
	private PostServices services;
	
  @RequestMapping(value="/{id}",method=RequestMethod.GET)	
  public ResponseEntity<Post> findByld(@PathVariable String id){
	  Post obj = services.FindByld(id);
	  return ResponseEntity.ok().body(obj);
	  
  }

 
}
