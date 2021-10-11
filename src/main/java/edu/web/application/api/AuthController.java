package edu.web.application.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.web.application.api.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping(value = "/")
    public void auth(@RequestBody UserDto userDto, HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.info("!!!");
        new ObjectMapper().writeValue(response.getOutputStream(), userDto);
        response.sendRedirect("http://127.0.0.1:8080/api/login");
    }

    //TODO: реализовать при необходимости
}
