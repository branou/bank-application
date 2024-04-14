package dev.himbra.bankapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor @Setter @Getter @Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name",nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String userName;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="email",nullable = false)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy="client")
    private List<Account> accs;
}
