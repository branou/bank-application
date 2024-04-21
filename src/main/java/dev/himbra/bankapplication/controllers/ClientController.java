package dev.himbra.bankapplication.controllers;

import dev.himbra.bankapplication.dto.Clientdto;
import dev.himbra.bankapplication.entity.Client;
import dev.himbra.bankapplication.entity.Role;
import dev.himbra.bankapplication.security.ClientRequest;
import dev.himbra.bankapplication.security.JwtService;
import dev.himbra.bankapplication.security.LoginRequest;
import dev.himbra.bankapplication.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
@Tag(name = "Client" , description = "Client Controller")
public class ClientController {
    private ClientService clientService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt= jwtService.generateJwtToken(authentication);
        return ResponseEntity.ok(jwt);

    }
    @PostMapping("/add")
    public ResponseEntity<Client> createAccount(@RequestBody ClientRequest client){
       var acc= Client.builder()
               .id(client.getId()).firstName(client.getFirstName())
               .password(passwordEncoder.encode(client.getPassword())).role(Role.USER)
               .username(client.getUsername())
               .email(client.getEmail()).accs(new ArrayList<>())
               .lastName(client.getLastName()).build();
        return new ResponseEntity<>( clientService.addClient(acc), HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Clientdto>> getAllClients(){
        return new ResponseEntity<>(clientService.getAllClients(),HttpStatus.OK);
    }

}
