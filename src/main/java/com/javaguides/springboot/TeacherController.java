package com.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;
//import net.javaguides.springboot.exception.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TeacherController {
    @Autowired
    private TeacherServiceImplement teacherService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private  TeacherRepository teacherRepository;

    @PostMapping("/teacher")
    public void createTeacher(@RequestBody  TeacherDto teacherDto){
        Teacher teacher=modelMapper.map(teacherDto,Teacher.class);
        teacher=teacherService.createTeacher(teacher);
        TeacherDto teacherResponse=modelMapper.map(teacher,TeacherDto.class);
    }
    @GetMapping("/teacher")
    public List<TeacherDto> getTeachers(){
        return teacherService.getTeachers().stream().map(teacher -> modelMapper.map(teacher, TeacherDto.class))
                .collect(Collectors.toList());
    }
    @GetMapping("/teacher/{teacher_id}")
    public Optional<TeacherDto> getTeacherById(@PathVariable(name="teacher_id") Integer teacher_id){
        Optional<Teacher> teacher=teacherService.getTeacherById(teacher_id);
        Optional<TeacherDto> teacherDto=modelMapper.map(teacher,Optional.class);
        return teacherDto;
    }
    @PutMapping("teacher/{teacher_id}")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto,@PathVariable("teacher_id")Integer teacher_id){
        Teacher teacher=modelMapper.map(teacherDto,Teacher.class);
        teacher=teacherService.updateTeacher(teacher_id,teacher);
        TeacherDto teacherResponse=modelMapper.map(teacherDto,TeacherDto.class);
        return teacherResponse;
    }
    @DeleteMapping("teacher/{teacher_id}")
    public void deleteTeacher(@PathVariable("teacher_id")Integer teacher_id){
        teacherService.deleteTeacher(teacher_id);
    }
}
