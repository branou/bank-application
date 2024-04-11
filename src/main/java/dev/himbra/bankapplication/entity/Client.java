package dev.himbra.bankapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToOne(mappedBy="client")
    private Account acc;
}
