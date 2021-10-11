package edu.web.application.api;

import edu.web.application.api.dto.UserDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.specification.StudentSpecification;
import edu.web.application.model.specification.UserSpecification;
import edu.web.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto get(@PathVariable("id") Long id) throws ProjectException {
        log.info("Get student bu id [{}]", id);
        return userService.get(id);
    }

    @PostMapping("/")
    public UserDto add(@Valid @RequestBody UserDto userDto) throws ProjectException {
        log.info("Add new student with request [{}]", userDto);
        return userService.add(userDto);
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") Long id, @Valid @RequestBody UserDto userDto) throws ProjectException {
        log.info("Update student with request [{}]", userDto);
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws ProjectException {
        log.info("Delete student by id [{}]", id);
        userService.delete(id);
    }

    @GetMapping("/")
    public Page<UserDto> get(UserSpecification specification, Pageable pageable) {
        log.info("Get students by specification [{}]", specification);
        return userService.get(specification, pageable);
    }
}
