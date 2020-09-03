/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.silab.bgsound.dao.RentDAO;
import rs.ac.bg.silab.bgsound.entity.Client;
import rs.ac.bg.silab.bgsound.entity.Rent;
import rs.ac.bg.silab.bgsound.entity.Worker;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class RentDAOImpl implements RentDAO {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void discharge(int rent) {
        System.out.println("brisem\n\n\n\n");
        Rent r= entityManager.find(Rent.class, rent);
        r.getClient().setRents(null);
        System.out.println(r+"\n\n\n");
      entityManager.remove(r);
        
    }
    
    @Override
    public List<Rent> getAll() {
        String query = "select r from Rent r";
        return entityManager.createQuery(query, Rent.class).getResultList();
        
    }
    
    @Override
    public Rent getByID(int id) {
        Rent c = entityManager.find(Rent.class, id);
        System.out.println(c);
        return c;
        
    }
    
    @Override
    public void save(Rent rent) {
        System.out.println(rent + "\n\n\n\n\n");
        Client c=entityManager.find(Client.class, rent.getClient().getClientID());
        Worker w=entityManager.find(Worker.class, rent.getWorker().getUsername());
        rent.setClient(c);
        rent.setWorker(w);
        entityManager.merge(rent);
    }
    
}
