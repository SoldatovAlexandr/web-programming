package edu.web.application.api.mapper;

import edu.web.application.api.dto.RoleDto;
import edu.web.application.common.UserRoles;
import edu.web.application.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleDtoMapper {
    public Role to(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(UserRoles.valueOf(roleDto.getName()))
                .build();
    }

    public RoleDto from(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName().name())
                .build();
    }

    public List<RoleDto> fromSet(Set<Role> roles) {
        return roles.stream().map(this::from).collect(Collectors.toList());
    }
}
