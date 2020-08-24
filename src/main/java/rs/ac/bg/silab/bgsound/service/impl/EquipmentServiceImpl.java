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
import rs.ac.bg.silab.bgsound.dao.EquipmentDAO;
import rs.ac.bg.silab.bgsound.entity.Equipment;
import rs.ac.bg.silab.bgsound.service.EquipmentService;

/**
 *
 * @author user
 */
@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    EquipmentDAO storageEquipment;

    @Autowired
    public EquipmentServiceImpl(EquipmentDAO storageEquipment) {
        this.storageEquipment = storageEquipment;
    }

    @Override
    public List<Equipment> getAll() {
        return storageEquipment.getAll();
    }

    @Override
    public Equipment getByID(int id) {
        return storageEquipment.getByID(id);
    }

    @Override
    public void setEquipment(Equipment equipment) {
        storageEquipment.setEquipment(equipment);
    }

    @Override
    public List<Equipment> getByName(String Name) {
        return storageEquipment.getByName(Name);
    }

    @Override
    public void changeEquipment(Equipment equipment) {
        storageEquipment.changeEquipment(equipment);
    }

    @Override
    public boolean delete(int id) {
        return storageEquipment.delete(id);
    }

}
