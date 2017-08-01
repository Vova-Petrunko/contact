package com.contact.service;

import com.contact.entity.Client;

import java.util.List;

/**
 * Created by Вова on 01.08.2017.
 */
public interface ClientService {
    Client findById(Integer id);

    Client findByName(String name);

    void saveClient(Client client);

    void updateClient(Client client);

    void deleteClientById(Integer id);

    void deleteAllClients();

    List<Client> findAllClients();

}
