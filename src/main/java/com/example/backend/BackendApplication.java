package com.example.backend;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("alberto", "1234"));
		this.userRepository.save(new User("capuccino", "1234"));
		this.userRepository.save(new User("sahani", "1234"));
	}
}
