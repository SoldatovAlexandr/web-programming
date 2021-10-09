package edu.web.application.api;

import edu.web.application.api.dto.StudentDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.specification.StudentSpecification;
import edu.web.application.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public StudentDto get(@PathVariable("id") Long id) throws ProjectException {
        log.info("Get student bu id [{}]", id);
        return studentService.get(id);
    }

    @PostMapping("/")
    public StudentDto add(@Valid @RequestBody StudentDto studentDto) {
        log.info("Add new student with request [{}]", studentDto);
        return studentService.add(studentDto);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable("id") Long id, @Valid @RequestBody StudentDto studentDto) throws ProjectException {
        log.info("Update student with request [{}]", studentDto);
        return studentService.update(id, studentDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws ProjectException {
        log.info("Delete student by id [{}]", id);
        studentService.delete(id);
    }

    @GetMapping("/")
    public Page<StudentDto> get(StudentSpecification specification, Pageable pageable) {
        log.info("Get students by specification [{}]", specification);
        return studentService.get(specification, pageable);
    }
}
