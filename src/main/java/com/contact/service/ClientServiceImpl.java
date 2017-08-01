package com.contact.service;

import com.contact.dao.ClientDAO;
import com.contact.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Вова on 01.08.2017.
 */

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client findById(Integer id) {
        return clientDAO.findOne(id);
    }

    @Override
    public Client findByName(String name) {
        return clientDAO.findByName(name);
    }

    @Override
    public void saveClient(Client client) {
        clientDAO.save(client);
    }

    @Override
    public void updateClient(Client client) {
        saveClient(client);
    }

    @Override
    public void deleteClientById(Integer id) {
        clientDAO.delete(id);
    }

    @Override
    public void deleteAllClients() {
        clientDAO.deleteAll();
    }

    @Override
    public List<Client> findAllClients() {
        return (List<Client>) clientDAO.findAll();
    }

}
