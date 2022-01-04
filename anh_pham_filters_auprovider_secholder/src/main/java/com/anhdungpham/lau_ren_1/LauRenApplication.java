package com.anhdungpham.lau_ren_1;

import com.anhdungpham.lau_ren_1.entities.UserEntity;
import com.anhdungpham.lau_ren_1.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LauRenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LauRenApplication.class, args);
	}


}
