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
import rs.ac.bg.silab.bgsound.dao.ProducerDAO;
import rs.ac.bg.silab.bgsound.entity.EquipmentType;
import rs.ac.bg.silab.bgsound.entity.Producer;
import rs.ac.bg.silab.bgsound.service.ProducerService;

/**
 *
 * @author Milos
 */
@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

    private final ProducerDAO producerDAO;

    @Autowired
    public ProducerServiceImpl(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

    @Override
    public void save(Producer producer) {
        producerDAO.save(producer);

    }

    public List<Producer> getAll() {
        return producerDAO.getAll();

    }

    public List<EquipmentType> getAllTypes() {
        return producerDAO.getAllTypes();
    }

    public Producer getProducer(int id){
        return producerDAO.getProducer(id);
    }
    public EquipmentType getType(int id){
        return producerDAO.getType(id);
    }
}
