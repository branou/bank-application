package dev.himbra.bankapplication.service;

import dev.himbra.bankapplication.dto.Clientdto;
import dev.himbra.bankapplication.entity.Account;
import dev.himbra.bankapplication.entity.Client;

import java.util.List;

public interface ClientService {
    public Client addClient(Client cli);
    public List<Clientdto> getAllClients();
    public void deleteClient(Long id);
    public void updateClient(Long id,Client acc);
    public Client getClientById(Long id);
}
