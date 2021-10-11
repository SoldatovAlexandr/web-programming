package edu.web.application.service.impl;

import edu.web.application.api.dto.UserDto;
import edu.web.application.api.mapper.UserMapper;
import edu.web.application.common.UserRoles;
import edu.web.application.exception.ProjectException;
import edu.web.application.model.Movie;
import edu.web.application.model.User;
import edu.web.application.model.specification.UserSpecification;
import edu.web.application.repository.RoleRepository;
import edu.web.application.repository.UserRepository;
import edu.web.application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(login)
                .orElseThrow(() -> {
                    log.error("Пользователь не найден.");
                    throw new UsernameNotFoundException("Пользователь не найден.");
                });
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName().name())));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities);
    }

    @Override
    public UserDto get(Long id) throws ProjectException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Пользователь не найден."));
        return userMapper.from(user);
    }

    @Override
    public UserDto add(UserDto UserDto) throws ProjectException {
        User user = userMapper.to(UserDto);
        user.setRoles(Set.of(roleRepository.findByName(UserRoles.ROLE_USER)
                .orElseThrow(() -> new ProjectException("Роль не найдена."))));
        userRepository.save(user);
        return userMapper.from(user);
    }

    @Transactional
    @Override
    public UserDto update(Long id, UserDto userDto) throws ProjectException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Пользователь не найден."));
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return userMapper.from(user);
    }

    @Transactional
    @Override
    public void delete(Long id) throws ProjectException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ProjectException("Пользователь не найден."));
        userRepository.delete(user);
    }

    @Override
    public Page<UserDto> get(UserSpecification specification, Pageable pageable) {
        return userRepository.findAll(specification, pageable).map(userMapper::from);
    }
}
