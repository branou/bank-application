package dev.himbra.bankapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="accounts")
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="account_holder_name", nullable = false)
    private String accountHolderName;
    private double balance;
    @OneToOne
    @JoinColumn(name="client_Id")
    private Client client;
}
