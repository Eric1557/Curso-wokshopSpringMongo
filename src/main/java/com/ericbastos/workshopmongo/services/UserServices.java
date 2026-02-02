package com.ericbastos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericbastos.workshopmongo.domain.User;
import com.ericbastos.workshopmongo.dto.UserDTO;
import com.ericbastos.workshopmongo.repository.UserRepository;
import com.ericbastos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> FindAll(){
		return repo.findAll();
	}
	public User findByld(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("objeto não encontrado !"));
	}
	public User Insert(User obj) {
		return repo.insert(obj);
	}
    public User FromDTO(UserDTO obj) {
    	User user = new User(obj.getId(),obj.getName(),obj.getEmail());
    	return user;
    }
    
    public void delete(String id) {
    	findByld(id);
        repo.deleteById(id);
    }
    
    public User update(User obj) {
    	User newObj = repo.findById(obj.getId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        UpdateData(newObj,obj);
        return repo.save(newObj);
    
    }
    
	private void UpdateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
   
    
}
