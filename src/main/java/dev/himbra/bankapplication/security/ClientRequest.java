package dev.himbra.bankapplication.security;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ClientRequest {
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String username;

    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="email",nullable = false)
    private String email;
}
