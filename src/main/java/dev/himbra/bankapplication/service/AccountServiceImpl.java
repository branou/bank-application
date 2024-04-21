package dev.himbra.bankapplication.service;

import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.entity.Client;
import dev.himbra.bankapplication.exceptions.ResourceNotFoundException;
import dev.himbra.bankapplication.repository.AccountRepository;
import dev.himbra.bankapplication.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepo;
    private ClientRepository clientRepo;

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
        account.setAccountNumber(acc.getAccountNumber());
        account.setAccountType(acc.getAccountType());
        account.setClient(acc.getClient());
        accountRepo.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        Account acc=accountRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("account doesn't exist!!"));
        return acc;
    }

    @Override
    public void affectClient(Long clientId, Long accountId) {
        Client client= clientRepo.findById(clientId).orElseThrow(()-> new ResourceNotFoundException("Client not Found"));
        Account acc= accountRepo.findById(accountId).orElseThrow(()-> new ResourceNotFoundException("Account not Found"));
        acc.setClient(client);
        accountRepo.save(acc);
    }
}
