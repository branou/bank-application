package dev.himbra.bankapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="accounts")
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter @Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private double balance;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name="client_Id")
    private Client client;
}
