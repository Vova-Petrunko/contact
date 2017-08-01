package com.contact.controller;

import com.contact.entity.Client;
import com.contact.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Вова on 01.08.2017.
 */

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("clients",clientService.findAllClients());
        return "clients";
    }

    @RequestMapping("client/{id}")
    public String showClient(@PathVariable Integer id, Model model){
        model.addAttribute("client",clientService.findById(id));
        return "clientshow";
    }

    @RequestMapping("client/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("client",clientService.findById(id));
        return "clientform";
    }

    @RequestMapping("client/new")
    public String newClient(Model model){
        model.addAttribute("client", new Client());
        return "clientform";
    }

    @RequestMapping(value = "client", method = RequestMethod.POST)
    public RedirectView saveClient(Client client){
        clientService.saveClient(client);
        return new RedirectView("/client/"+client.getId());
    }

    @RequestMapping("client/delete/{id}")
    public RedirectView delete(@PathVariable Integer id){
        clientService.deleteClientById(id);
        return new RedirectView("/clients");
    }
}
