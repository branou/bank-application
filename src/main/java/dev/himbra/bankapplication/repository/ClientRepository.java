package dev.himbra.bankapplication.repository;

import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByUsername(String username);
}
