package dev.himbra.bankapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor @Setter @Getter
public class Client {
    @Column(name="client_id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name",nullable = false)
    private String firstName;
    @Column(name="last_name",nullable = false)
    private String lastName;
    @Column(name="password",nullable = false)
    private String password;
    @Column(name="email",nullable = false)
    private String email;


}
