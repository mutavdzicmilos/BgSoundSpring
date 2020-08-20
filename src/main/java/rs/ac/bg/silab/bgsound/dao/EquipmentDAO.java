/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.dao;

import java.util.List;
import rs.ac.bg.silab.bgsound.entity.Equipment;

/**
 *
 * @author user
 */
public interface EquipmentDAO {

    List<Equipment> getAll();

    Equipment getByID(int id);

    void setEquipment(Equipment equipment);

    List<Equipment> getByName(String Name);

    Equipment changeEquipment(Equipment equipment);

    boolean delete(int id);

}
