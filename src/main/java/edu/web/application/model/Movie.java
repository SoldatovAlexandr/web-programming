package edu.web.application.model;

import lombok.*;

import javax.persistence.*;

/*
 * Класс сущности
 * 2 ЛР 22 вариант
 * Солдатов А.Н. ПИН-181
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(generator = "h_sequence")
    @SequenceGenerator(name = "h_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;
}
