package com.springboot.restapiwithdockermongdb.repository;

import com.springboot.restapiwithdockermongdb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);
}
