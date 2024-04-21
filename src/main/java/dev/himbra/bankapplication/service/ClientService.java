package dev.himbra.bankapplication.service;

import dev.himbra.bankapplication.dto.Clientdto;
import dev.himbra.bankapplication.entity.Client;
import dev.himbra.bankapplication.entity.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ClientService {
    public Client addClient(Client cli);
    public List<Clientdto> getAllClients();
    public void deleteClient(Long id);
    public void updateClient(Long id,Client acc);
    public Client getClientById(Long id);
    //public UserDetailsService loadUserbyUsername(String username);
    public void AddRoleToUser(String username, Role role);
}
