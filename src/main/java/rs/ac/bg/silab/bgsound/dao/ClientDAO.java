/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.dao;

import java.util.List;
import rs.ac.bg.silab.bgsound.entity.Client;
/**
 *
 * @author user
 */
public interface ClientDAO {
    void saveClient(Client client);
    List<Client> returnAllClients() ;
    Client returnByID(int id);
     boolean deleteClient(Client  client) ;
    Client updateClient(Client client);
    
     
}
