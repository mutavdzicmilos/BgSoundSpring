/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Milos
 */
@Entity
@Table(name = "copy")
public class Copy implements Serializable {

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinColumn(name = "equipmentid")
    private Equipment equipment;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "copyID")
    private Integer copyID;
    private boolean working;
    private boolean available;
    private String defect;
    private Integer rentid;

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

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public Integer getRentid() {
        return rentid;
    }

    public void setRentid(Integer rentid) {
        this.rentid = rentid;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Copy{" + ", copyID=" + copyID ;
    }

   

}
