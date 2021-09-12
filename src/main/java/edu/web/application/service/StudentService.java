package edu.web.application.service;

import edu.web.application.api.dto.StudentDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.Student;
import edu.web.application.model.specification.StudentSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentDto get(Long id) throws ProjectException;

    StudentDto add(StudentDto studentDto);

    StudentDto update(Long id, StudentDto studentDto);

    void delete(Long id) throws ProjectException;

    Page<StudentDto> get(StudentSpecification specification, Pageable pageable);
}
