package edu.web.application.service.impl;

import edu.web.application.api.dto.StudentDto;
import edu.web.application.api.mapper.StudentMapper;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.Student;
import edu.web.application.repository.StudentRepository;
import edu.web.application.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDto get(Long id) throws ProjectException {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Пользователь не найден."));
        return studentMapper.from(student);
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        Student student = studentMapper.to(studentDto);
        studentRepository.save(student);
        return studentMapper.from(student);
    }

    @Transactional
    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        Student student = studentMapper.to(studentDto);
        studentRepository.save(student);
        return studentMapper.from(student);
    }

    @Transactional
    @Override
    public void delete(Long id) throws ProjectException {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Пользователь не найден."));
        studentRepository.delete(student);
    }
}
