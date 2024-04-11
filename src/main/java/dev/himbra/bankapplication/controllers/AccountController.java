package dev.himbra.bankapplication.controllers;

import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.service.AccountService;
import dev.himbra.bankapplication.service.AccountServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Account", description = "Account Controller")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/add")
    public ResponseEntity<Account> createAccount(@RequestBody Account acc){
        return new ResponseEntity<>( accountService.createAccount(acc), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable Long id,@RequestBody Account acc){
        accountService.updateAccount(id,acc);
        return new ResponseEntity<>("the account with id = "+id+" updated successfully",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("the account with id = "+id+" deleted successfully",HttpStatus.NO_CONTENT);
    }
    @GetMapping("/affectClient/{clientId}/{accountId}")
    public ResponseEntity<String> affectClient(@PathVariable Long clientId,@PathVariable Long accountId){
        accountService.affectClient(clientId,accountId);
        return new ResponseEntity<>("done",HttpStatus.OK);
    }
}
