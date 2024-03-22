package dev.himbra.bankapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

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
}
