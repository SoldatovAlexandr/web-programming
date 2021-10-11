package edu.web.application.service;

import edu.web.application.api.dto.StudentDto;
import edu.web.application.api.mapper.StudentMapper;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.Student;
import edu.web.application.repository.StudentRepository;
import edu.web.application.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    private StudentService studentService;

    private final StudentRepository repository = Mockito.mock(StudentRepository.class);
    private final StudentMapper studentMapper = new StudentMapper();
    private final Student student = Student.builder()
            .id(1L)
            .name("Иван")
            .groupName("ПИН-181")
            .subgroup(2)
            .cardNumber("12343")
            .email("ivan@gmail.com")
            .build();
    private final StudentDto studentDto = StudentDto.builder()
            .id(1L)
            .name("Иван")
            .groupName("ПИН-181")
            .subgroup(2)
            .cardNumber("12343")
            .email("ivan@gmail.com")
            .build();

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl(repository, studentMapper);
    }

    @Test
    void get_success() throws ProjectException {
        when(repository.findById(1L)).thenReturn(Optional.of(student));

        StudentDto resultDto = studentService.get(1L);

        assertEquals(studentDto, resultDto);
        verify(repository).findById(1L);
    }

    @Test
    void get_error() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ProjectException.class, () -> studentService.get(1L));
    }

    @Test
    void add_success() {
        when(repository.save(student)).thenReturn(student);

        StudentDto resultDto = studentService.add(studentDto);

        assertEquals(studentDto, resultDto);
        verify(repository).save(student);
    }

    @Test
    void update_success() throws ProjectException {
        when(repository.findById(1L)).thenReturn(Optional.of(student));
        when(repository.save(student)).thenReturn(student);

        StudentDto resultDto = studentService.update(1L, studentDto);

        assertEquals(studentDto, resultDto);
    }

    @Test
    void delete_success() throws ProjectException {
        when(repository.findById(1L)).thenReturn(Optional.of(student));

        studentService.delete(1L);

        verify(repository).findById(1L);
        verify(repository).delete(student);
    }
}
