package dev.himbra.bankapplication.service;

import dev.himbra.bankapplication.entity.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account acc);
    public List<Account> getAllAccounts();
    public void deleteAccount(Long id);
    public void updateAccount(Long id,Account acc);
    public Account getAccountById(Long id);
}
