package com.contact.dao;

import com.contact.entity.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Вова on 01.08.2017.
 */
public interface ClientDAO extends CrudRepository<Client,Integer> {
    Client findByName(String name);
}
