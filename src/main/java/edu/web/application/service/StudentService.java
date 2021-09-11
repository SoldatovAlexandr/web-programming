package edu.web.application.service;

import edu.web.application.api.dto.StudentDto;
import edu.web.application.exception.ProjectException;

public interface StudentService {
    StudentDto get(Long id) throws ProjectException;

    StudentDto add(StudentDto studentDto);

    StudentDto update(Long id, StudentDto studentDto);

    void delete(Long id) throws ProjectException;
}
