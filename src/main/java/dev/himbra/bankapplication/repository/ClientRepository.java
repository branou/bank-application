package dev.himbra.bankapplication.repository;

import dev.himbra.bankapplication.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
