package com.amirabadi.chapar_practice_project.data.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

//    @NotNull
//    @Size(max = 100)
//    @Email
    @Column(nullable = false, columnDefinition = "char(100)")
    private String email;

//    @NotNull
//    @Size(max = 100)
//    @Column(columnDefinition = "varchar(100)")
    @Column(length = 100)
    private String firstname;

    /*@NotNull
    @Size(max = 100)*/
    private String lastname;

    @Column(length = 500)
    private String description;

}
