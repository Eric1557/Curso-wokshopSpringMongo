package com.ericbastos.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericbastos.workshopmongo.domain.User;
import com.ericbastos.workshopmongo.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> FindAll(){
		return repo.findAll();
	}

}
