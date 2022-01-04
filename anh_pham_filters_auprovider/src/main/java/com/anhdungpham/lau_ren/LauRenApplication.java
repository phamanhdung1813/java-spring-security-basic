package com.anhdungpham.lau_ren;

import com.anhdungpham.lau_ren.entities.UserEntity;
import com.anhdungpham.lau_ren.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LauRenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LauRenApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			userRepository.save(new UserEntity(1, "admin","admin", "WRITE"));
		};
	}
}
