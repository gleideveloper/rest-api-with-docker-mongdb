package com.springboot.restapiwithdockermongdb.api;

import com.springboot.restapiwithdockermongdb.service.StudentService;
import com.springboot.restapiwithdockermongdb.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(value = "/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping(value = "/")
    public Optional<Student> getStudent(@RequestParam("email") String email){
        return studentService.getStudent(email);
    }
    @PostMapping
    public Student created(@RequestBody Student student){
        return studentService.create(student);
    }
    @PutMapping
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

}
