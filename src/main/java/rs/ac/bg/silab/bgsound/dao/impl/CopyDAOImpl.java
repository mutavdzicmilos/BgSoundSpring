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
import rs.ac.bg.silab.bgsound.dao.CopyDAO;
import rs.ac.bg.silab.bgsound.entity.Copy;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class CopyDAOImpl implements CopyDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Copy returnByID(int id) {
        Copy c = entityManager.find(Copy.class, id);
        System.out.println(c);
        return c;
    }

    @Override
    public void deleteCopy(int copy) {
        Copy c= returnByID(copy);
        c.setEquipment(null);
        entityManager.remove(c);

    }

    @Override
    public void updateCopy(Copy copy) {
        Copy c = returnByID(copy.getCopyID());
        c.setWorking(copy.getWorking());
        c.setAvailable(copy.getAvailable());
        c.setDefect(copy.getDefect());
        entityManager.merge(c);
    }

    @Override
    public List<Copy> getAll() {
        String query = "select c from Copy c where c.rentid IS NULL";
        return entityManager.createQuery(query, Copy.class).getResultList();

    }

}
