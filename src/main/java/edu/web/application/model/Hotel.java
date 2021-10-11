package edu.web.application.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @SequenceGenerator(name = "h_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "count_visitor")
    private Long countVisitor;

    @Column(name = "director_name")
    private String directorName;

    @Column(name = "address")
    private String address;
}
