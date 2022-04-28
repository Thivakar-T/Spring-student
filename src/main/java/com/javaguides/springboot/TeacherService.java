package com.javaguides.springboot;
import java.util.List;
import java.util.Optional;
public interface TeacherService {
    List<Teacher> getTeachers();
    Teacher createTeacher(Teacher teacher);
    Optional<Teacher> getTeacherById(int id);
    Teacher updateTeacher(int id, Teacher teacher);
    void deleteTeacher(int id);
}
