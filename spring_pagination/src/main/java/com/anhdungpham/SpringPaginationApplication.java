package com.anhdungpham;

import com.anhdungpham.entities.AEntity;
import com.anhdungpham.entities.BEntity;
import com.anhdungpham.services.DBService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringPaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPaginationApplication.class, args);
    }

    @Bean
    public CommandLineRunner importDefaultDatabase(DBService dbService) {
        return args -> {
            dbService.saveA(new AEntity(null, "admin", new ArrayList<>()));
            dbService.saveA(new AEntity(null, "subadmin", new ArrayList<>()));

            dbService.saveB(new BEntity(null, "ROLE_ADMIN"));
            dbService.saveB(new BEntity(null, "ROLE_MANAGER"));

            dbService.addBtoA("admin", "ROLE_ADMIN");
            dbService.addBtoA("admin", "ROLE_MANAGER");
            dbService.addBtoA("subadmin", "ROLE_ADMIN");
        };

    }
}
