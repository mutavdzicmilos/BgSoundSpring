/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.service;

import java.util.List;
import rs.ac.bg.silab.bgsound.entity.Equipment;

/**
 *
 * @author Milos
 */
public interface EquipmentService {

    List<Equipment> getAll();

    Equipment getByID(int id);

    void saveEquipment(Equipment equipment);

    List<Equipment> getByName(String Name);

    void changeEquipment(Equipment equipment);

    boolean delete(int id);
}
