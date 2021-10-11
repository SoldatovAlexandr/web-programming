package edu.web.application.api.mapper;

import edu.web.application.api.dto.UserDto;
import edu.web.application.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User to(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .login(userDto.getLogin())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .build();
    }

    public UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .roles(new RoleDtoMapper().fromSet(user.getRoles()))
                .build();
    }
}
