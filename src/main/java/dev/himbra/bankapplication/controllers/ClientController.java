package dev.himbra.bankapplication.controllers;

import dev.himbra.bankapplication.dto.Clientdto;
import dev.himbra.bankapplication.entity.Client;
import dev.himbra.bankapplication.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
@Tag(name = "Client" , description = "Client Controller")
public class ClientController {
    private ClientService clientService;
    @PostMapping("/add")
    public ResponseEntity<Client> createAccount(@RequestBody Client acc){
        return new ResponseEntity<>( clientService.addClient(acc), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Clientdto>> getAllClients(){
        return new ResponseEntity<>(clientService.getAllClients(),HttpStatus.OK);
    }
}
