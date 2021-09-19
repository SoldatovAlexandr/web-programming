package edu.web.application.service;

import edu.web.application.api.dto.UserDto;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.specification.UserSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {


    UserDto get(Long id) throws ProjectException;

    UserDto add(UserDto UserDto) throws ProjectException;

    UserDto update(Long id, UserDto UserDto);

    void delete(Long id) throws ProjectException;

    Page<UserDto> get(UserSpecification specification, Pageable pageable);

}
