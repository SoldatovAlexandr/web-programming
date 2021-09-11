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
@Table(name = "student")
public class Student {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "subgroup")
    private Integer subgroup;
}
