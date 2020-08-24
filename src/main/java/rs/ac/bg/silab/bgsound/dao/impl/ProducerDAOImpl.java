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
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import rs.ac.bg.silab.bgsound.dao.ProducerDAO;
import rs.ac.bg.silab.bgsound.entity.Equipment;
import rs.ac.bg.silab.bgsound.entity.EquipmentType;
import rs.ac.bg.silab.bgsound.entity.Producer;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class ProducerDAOImpl implements ProducerDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Producer producer) {
        entityManager.merge(producer);
    }

    public List<Producer> getAll() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        String query = "select p from Producer p";
        return entityManager.createQuery(query, Producer.class).getResultList();

    }

    @Override
    public List<EquipmentType> getAllTypes() {
        String query = "select t from EquipmentType t";
        return entityManager.createQuery(query, EquipmentType.class).getResultList();
    }

    public Producer getProducer(int id) {
        return entityManager.find(Producer.class, id);
    }

    public EquipmentType getType(int id) {
        return entityManager.find(EquipmentType.class, id);
    }
}
