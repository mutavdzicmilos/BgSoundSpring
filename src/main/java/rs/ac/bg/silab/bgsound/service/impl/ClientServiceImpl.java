/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.silab.bgsound.dao.ClientDAO;
import rs.ac.bg.silab.bgsound.dao.impl.ClientDAOImpl;
import rs.ac.bg.silab.bgsound.entity.Client;
import rs.ac.bg.silab.bgsound.service.ClientService;

/**
 *
 * @author user
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    ClientDAO storageClient;

    @Autowired
    public ClientServiceImpl(ClientDAO storageClient) {
        this.storageClient = storageClient;
    }


    @Override
    public void saveClient(Client client) {
        storageClient.saveClient(client);
    }

    @Override
    public List<Client> returnAllClients() {
        return storageClient.returnAllClients();
    }

    @Override
    public List<Client> returnByName(String name) {
        return storageClient.returnByName(name);
    }

    @Override
    public Client returnByID(int id) {
        return storageClient.returnByID(id);
    }

    @Override
    public Client updateClient(Client client) {
        return storageClient.updateClient(client);
    }

    @Override
    public boolean deleteClient(int client) {
        return storageClient.deleteClient(client);

    }

}
