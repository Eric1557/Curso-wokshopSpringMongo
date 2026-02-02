package com.ericbastos.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
 
 @RequestMapping(value="/{id}",method=RequestMethod.GET)	
 public ResponseEntity<UserDTO> findByld(@PathVariable String id){
	 User obj = services.findByld(id); 
     return ResponseEntity.ok().body(new UserDTO(obj));
    
   }
 
 @RequestMapping(method=RequestMethod.POST)
 public ResponseEntity<Void> Insert(@RequestBody UserDTO objDto){
	User obj = services.FromDTO(objDto);
	obj = services.Insert(obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
 }
 
 @RequestMapping(value= "/{id}",method=RequestMethod.DELETE)
 public ResponseEntity<Void> delete(@PathVariable String id){
	 services.delete(id);
	 return ResponseEntity.noContent().build();
 }
 
}
