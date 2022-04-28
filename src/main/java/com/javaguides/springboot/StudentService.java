package com.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public  StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public List<Student> getStudents(){
        return studentRepository.findAll(); }
    public void deleteStudent(Integer student_id){
        studentRepository.deleteById(student_id);
    }
    public Optional<Student> getStudent(Integer student_id){
        return studentRepository.findById(student_id);
    }
    public Student updateStudent(Student student, Integer student_id){
        student.setId(student_id);
        return studentRepository.save(student);
    }
}