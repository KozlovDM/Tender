package com.wallaby.tender.controller;

import com.wallaby.tender.entity.Client;
import com.wallaby.tender.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/signUp")
    public Client SignUp(@RequestBody Client client){
        if (client.getName().isEmpty() || client.getPhoneNumber().isEmpty() || client.getPassword().isEmpty()){
            return null;
        }
        return clientService.SignUp(client);
    }

    @PostMapping("/signIn")
    public Client SignIn(@RequestBody Client client){
        if (client.getPhoneNumber().isEmpty() || client.getPassword().isEmpty()){
            return null;
        }
        return clientService.SignIn(client);
    }
}
