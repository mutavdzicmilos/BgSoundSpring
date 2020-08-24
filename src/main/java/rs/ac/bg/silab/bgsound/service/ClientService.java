/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.service;

import java.util.List;
import rs.ac.bg.silab.bgsound.entity.Client;

/**
 *
 * @author user
 */
public interface ClientService {

    void saveClient(Client client);

    List<Client> returnAllClients();


    Client returnByID(int id);

    boolean deleteClient(int client);

    Client updateClient(Client client);

}
