package edu.web.application.api.mapper;

import edu.web.application.api.dto.StudentDto;
import edu.web.application.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student to(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .email(studentDto.getEmail())
                .cardNumber(studentDto.getCardNumber())
                .groupName(studentDto.getGroupName())
                .subgroup(studentDto.getSubgroup())
                .build();
    }

    public StudentDto from(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .cardNumber(student.getCardNumber())
                .groupName(student.getGroupName())
                .subgroup(student.getSubgroup())
                .build();
    }
}
