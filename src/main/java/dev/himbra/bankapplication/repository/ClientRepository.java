package dev.himbra.bankapplication.repository;

import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Account> findByUserName(String userName);
}
