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
import rs.ac.bg.silab.bgsound.dao.EquipmentDAO;
import rs.ac.bg.silab.bgsound.entity.Copy;
import rs.ac.bg.silab.bgsound.entity.Equipment;
import rs.ac.bg.silab.bgsound.entity.EquipmentType;
import rs.ac.bg.silab.bgsound.entity.Producer;

/**
 *
 * @author Milos
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class EquipmentDAOImpl implements EquipmentDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)//ako postoi u okviru nje, ako ne bez
    @Override
    public List<Equipment> getAll() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        String query = "select e from Equipment e";
        return entityManager.createQuery(query, Equipment.class).getResultList();

    }

    @Override
    public Equipment getByID(int id) {
        Equipment e = entityManager.find(Equipment.class, id);
        return e;

    }

    @Override
    public void setEquipment(Equipment equipment) {
        int id= equipment.getProducer().getProducerid();
        Producer prod=entityManager.find(Producer.class, id);
        equipment.setProducer(prod);
        id= equipment.getType().getEquipmentTypeID();
        EquipmentType type= entityManager.find(EquipmentType.class, id);
        equipment.setType(type);
        entityManager.merge(equipment);
    }

    @Override
    public List<Equipment> getByName(String Name) {
        Query query = entityManager.createQuery("SELECT e FROM Equipment e where name like :name%", Equipment.class);
        query.setParameter("name", Name);
        return query.getResultList();
    }

    @Override
    public void changeEquipment(Equipment equipment) {

       int id= equipment.getProducer().getProducerid();
        Producer prod=entityManager.find(Producer.class, id);
        equipment.setProducer(prod);
        id= equipment.getType().getEquipmentTypeID();
        EquipmentType type= entityManager.find(EquipmentType.class, id);
        equipment.setType(type);
        entityManager.merge(equipment);
    }

    @Override
    public boolean delete(int id) {
        entityManager.remove(getByID(id));
        return true;
    }

}
