package dev.himbra.bankapplication.repository;

import dev.himbra.bankapplication.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<Account,Long> {
}
