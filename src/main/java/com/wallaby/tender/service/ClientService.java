package com.wallaby.tender.service;

import com.wallaby.tender.entity.Client;
import com.wallaby.tender.repository.ClientReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientReposirory clientReposirory;

    public Client SignUp(Client client){
        if (clientReposirory.existsByPhoneNumber(client.getPhoneNumber())){
            return null;
        }
        client.setRating(0);
        return clientReposirory.save(client);
    }

    public Client SignIn(Client client){
        Client clientFromDB = clientReposirory.findByPhoneNumber(client.getPhoneNumber());
        if (clientFromDB != null && clientFromDB.getPassword().equals(client.getPassword())){
            return clientFromDB;
        }
        return null;
    }
}
