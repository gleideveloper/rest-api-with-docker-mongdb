package com.springboot.restapiwithdockermongdb.service;

import com.springboot.restapiwithdockermongdb.repository.StudentRepository;
import com.springboot.restapiwithdockermongdb.entity.Student;
import com.springboot.restapiwithdockermongdb.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(String email){
        return studentRepository.findStudentByEmail(email);
    }

    public Student create (Student student){
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        var entity = studentRepository.findStudentByEmail(student.getEmail()).orElseThrow(
                ()-> new ResourceNotFoundException("Student Not Found"));
        entity.setFirstName(student.getFirstName());
        entity.setLastName(student.getLastName());
        return studentRepository.save(entity);
    }
}
