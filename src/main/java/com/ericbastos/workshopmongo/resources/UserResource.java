package com.ericbastos.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ericbastos.workshopmongo.domain.User;

@RestController
@RequestMapping("/users")
public class UserResource {
	
 @RequestMapping(method=RequestMethod.GET)	
  public ResponseEntity<List<User>> findAll(){
	  User eric = new User("1","eric","eric@gmail.com");
	  User davi = new User("2","davi","davi@gmail.com");
      List<User> list = new ArrayList<>();
      list.addAll(Arrays.asList(eric,davi));
      return ResponseEntity.ok().body(list);
  }

}
