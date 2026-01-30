package com.ericbastos.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ericbastos.workshopmongo.domain.User;
import com.ericbastos.workshopmongo.dto.UserDTO;
import com.ericbastos.workshopmongo.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserServices services;
	
 @RequestMapping(method=RequestMethod.GET)	
  public ResponseEntity<List<UserDTO>> findAll(){
      List<User> list = services.FindAll();
      List<UserDTO> listdto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
      return ResponseEntity.ok().body(listdto);
  }

}
