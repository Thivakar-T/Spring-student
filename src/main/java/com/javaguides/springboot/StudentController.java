package com.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/student/{student_id}")
    public Optional<Student> getStudent(@PathVariable("student_id") Integer student_id){
        return studentService.getStudent(student_id);
    }

    @PutMapping("/student/{student_id}")
    public Student updateStudet(@RequestBody Student student,@PathVariable("student_id") Integer student_id){
        return studentService.updateStudent(student,student_id);
    }

    @DeleteMapping("/student/{student_id}")
    public void deleteStudent(@PathVariable("student_id") Integer student_id){
        studentService.deleteStudent(student_id);
    }
}
