/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "equipmenttype")
public class EquipmentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipmenttypeid")
    private int equipmentTypeID;
    @Column
    private String type;
     @Lob
    private byte[] equipmentPicture;

    public EquipmentType(int equipmentTypeID, String type, byte[] equipmentPicture) {
        this.equipmentTypeID = equipmentTypeID;
        this.type = type;
        this.equipmentPicture = equipmentPicture;
    }

    public EquipmentType() {
    }

    public int getEquipmentTypeID() {
        return equipmentTypeID;
    }

    public void setEquipmentTypeID(int equipmentTypeID) {
        this.equipmentTypeID = equipmentTypeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getEquipmentPicture() {
        return equipmentPicture;
    }

    public void setEquipmentPicture(byte[] equipmentPicture) {
        this.equipmentPicture = equipmentPicture;
    }

    @Override
    public String toString() {
        return type;
    }

  
}
