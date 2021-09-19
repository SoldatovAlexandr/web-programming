package edu.web.application.repository;

import edu.web.application.common.UserRoles;
import edu.web.application.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(UserRoles name);
}
