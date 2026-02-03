package com.ericbastos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ericbastos.workshopmongo.domain.Post;
import com.ericbastos.workshopmongo.domain.User;
import com.ericbastos.workshopmongo.repository.PostRepository;
import com.ericbastos.workshopmongo.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		User maria = new User(null,"Maria","maria@gmail.com");
		User alex = new User(null,"Alex","alex@gmail.com");
		User bob = new User(null,"Bob","bob@gmail.com");
		
		Post post1 = new Post(null,sdf.parse("03/02/2026"),"Partiu Viagem","Vou viajar para São Paulo. Abraços!",maria);
		Post post2 = new Post(null,sdf.parse("02/02/2026"),"Partiu Viagem","Vou viajar para São Paulo. Abraços!",maria);
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
