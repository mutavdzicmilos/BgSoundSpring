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
import javax.persistence.Table;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "copy")
public class Copy implements Serializable {

    @Column(name = "equipmentid")
    private Integer equipmentid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "copyID")
    private Integer copyID;
    private boolean working;
    private boolean available;
    private String defect;

    public Copy() {
        working = true;
        available = true;
        defect = null;

    }

    public Integer getCopyID() {
        return copyID;
    }

    public void setCopyID(Integer copyID) {
        this.copyID = copyID;
    }

    public Boolean getWorking() {
        return working;
    }

    public void setWorking(Boolean working) {
        this.working = working;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getEquipmentId() {
        return equipmentid;
    }

    public void setEquipmentid(int equipment) {
        this.equipmentid = equipment;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

}
