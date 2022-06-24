package com.springboot.restapiwithdockermongdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class RestApiWithMongdbApp {

    public static void main(String[] args) {
        SpringApplication.run(RestApiWithMongdbApp.class, args);
    }
    @Bean
    CommandLineRunner runner(StudentRepository repository){
        return args -> {
            Address address = new Address(
                    "Brazil",
                    "Manaus",
                    "69058-418"
            );
          Student student = new Student(
                  "Gleides",
                  "Vinente",
                  "gvs@gmail.com",
                  Gender.MALE, address,
                  List.of("Engineer Science"),
                  BigDecimal.TEN,
                  LocalDateTime.now()
          );
          repository.insert(student);
        };
    }

}
