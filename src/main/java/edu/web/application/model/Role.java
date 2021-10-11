package edu.web.application.model;

import edu.web.application.common.UserRoles;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(generator = "h_sequence")
    @SequenceGenerator(name = "h_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private UserRoles name;
}
