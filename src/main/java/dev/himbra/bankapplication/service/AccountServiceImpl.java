package dev.himbra.bankapplication.service;

import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepo;

    public Account createAccount(Account acc) {
        accountRepo.save(acc);
        return acc;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accs = accountRepo.findAll();
        return accs;
    }

    @Override
    public void deleteAccount(Long id) {
        Optional<Account> acc = accountRepo.findById(id);
        Account account = acc.get();
        accountRepo.delete(account);
    }

    @Override
    public void updateAccount(Long id, Account acc) {
        Optional<Account> accToUpdate = accountRepo.findById(id);
        Account account = accToUpdate.get();
        account.setBalance(acc.getBalance());
        account.setAccountHolderName(acc.getAccountHolderName());
    }
}
