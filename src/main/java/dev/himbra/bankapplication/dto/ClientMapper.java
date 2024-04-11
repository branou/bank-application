package dev.himbra.bankapplication.dto;

import dev.himbra.bankapplication.entity.Client;

public class ClientMapper {
    public static Clientdto maptoClientdto(Client client){
        return new Clientdto(client.getId(),client.getFirstName(),client.getLastName());
    }

}
