package dev.himbra.bankapplication.service;

import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.exceptions.ResourceNotFoundException;
import dev.himbra.bankapplication.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
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
        Account account = getAccountById(id);
        accountRepo.delete(account);
    }

    @Override
    public void updateAccount(Long id, Account acc) {
        Account account = getAccountById(id);
        account.setBalance(acc.getBalance());
        account.setAccountHolderName(acc.getAccountHolderName());
    }

    @Override
    public Account getAccountById(Long id) {
        Account acc=accountRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("account doesn't exist!!"));
        return acc;
    }
}
