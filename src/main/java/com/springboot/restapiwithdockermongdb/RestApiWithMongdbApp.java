package com.springboot.restapiwithdockermongdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class RestApiWithMongdbApp {

    public static void main(String[] args) {
        SpringApplication.run(RestApiWithMongdbApp.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address(
                    "USA",
                    "California",
                    "456-418"
            );
            String email = "salves@gmail.com";
            Student student = new Student(
                    "Samanta",
                    "Alves",
                    email,
                    Gender.FEMALE, address,
                    List.of("Lawyer"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(email));

            List<Student> students = mongoTemplate.find(query, Student.class);
            if (students.size() > 1){
                throw new IllegalStateException(
                        "Found many students with email" + email
                );
            }
            if(students.isEmpty()){
                System.out.println("Inserting student" + student);
                repository.insert(student);
            }else{
                System.out.println(student + "alredy exists");
            }
        };
    }

}
