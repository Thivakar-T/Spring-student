package com.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImplement implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

//    public void addTeacher(Teacher teacher){
//        teacherRepository.save(teacher);
//    }
//    public List<Teacher> getTeachers(){
//        return teacherRepository.findAll();
//    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return  teacherRepository.save(teacher);
    }

    @Override
    public Optional<Teacher> getTeacherById(int teacher_id) {
        return teacherRepository.findById(teacher_id);
    }

    @Override
    public Teacher updateTeacher(int teacher_id, Teacher teacher) {
        teacher.setId(teacher_id);
        return teacherRepository.save(teacher);
        }

    @Override
    public void  deleteTeacher(int teacher_id) {
        teacherRepository.deleteById(teacher_id);
    }

//    public Optional<Teacher> getTeacher(Integer teacher_id){
//        return teacherRepository.findById(teacher_id);
//    }
//    public Teacher updateTeacher(Teacher teacher,Integer teacher_id){
//        teacher.setId(teacher_id);
//        return teacherRepository.save(teacher);
//    }
//    public void deleteTeacher(Integer teacher_id){
//        teacherRepository.deleteById(teacher_id);
//    }
}
