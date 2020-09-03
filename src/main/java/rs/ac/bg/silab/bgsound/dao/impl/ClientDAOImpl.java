/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import rs.ac.bg.silab.bgsound.dao.ClientDAO;
import rs.ac.bg.silab.bgsound.entity.Client;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class ClientDAOImpl implements ClientDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveClient(Client client) {
//persist radio
        entityManager.merge(client);
    }

    @Transactional(propagation = Propagation.REQUIRED)//ako postoi u okviru nje, ako ne bez
    @Override
    public List<Client> returnAllClients() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        String query = "select c from Client c";
              return entityManager.createQuery(query, Client.class).getResultList();

    }

  

    @Override
    public Client returnByID(int id) {

        return entityManager.find(Client.class, id);
    }

    @Override
    public Client updateClient(Client client) {

        return entityManager.merge(client);

    }

    @Override
    public boolean deleteClient(Client client) {
        entityManager.remove(returnByID(client.getClientID()));
        return true;
    }

}
