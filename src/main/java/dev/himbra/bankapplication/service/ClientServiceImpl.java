package dev.himbra.bankapplication.service;

import dev.himbra.bankapplication.dto.ClientMapper;
import dev.himbra.bankapplication.dto.Clientdto;
import dev.himbra.bankapplication.entity.Client;
import dev.himbra.bankapplication.exceptions.ResourceNotFoundException;
import dev.himbra.bankapplication.repository.ClientRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepo;
    @Override
    public Client addClient(Client cli) {
        return clientRepo.save(cli) ;
    }

    @Override
    public List<Clientdto> getAllClients() {
        return clientRepo.findAll().stream().map(client -> ClientMapper.maptoClient(client)).collect(Collectors.toList());
    }

    @Override
    public void deleteClient(Long id) {
        Client cli = getClientById(id);
        clientRepo.delete(cli);
    }

    @Override
    public void updateClient(Long id, Client acc) {
        Client cli = getClientById(id);
        cli.setFirstName(acc.getFirstName());cli.setLastName(acc.getLastName());
        cli.setEmail(acc.getEmail());cli.setPassword(acc.getPassword());
        clientRepo.save(cli);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client with id = " +id+"doesn't exist"));
    }
}
