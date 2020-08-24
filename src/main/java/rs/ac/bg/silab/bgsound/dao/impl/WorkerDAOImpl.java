/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.silab.bgsound.dao.WorkerDAO;
import rs.ac.bg.silab.bgsound.entity.Worker;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class WorkerDAOImpl implements WorkerDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Worker getWorker(String username) {
        Query query = entityManager.createQuery("select w from Worker w where w.username=:user");
        query.setParameter("user", username);
        return (Worker) query.getSingleResult();
    }

}
