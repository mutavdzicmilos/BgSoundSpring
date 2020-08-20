/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author FON
 */
@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipmentID")
    private Integer equipmentID;
    private String name;
    private String connection;
    private String specification;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipmentid", referencedColumnName = "equipmentID")
    private List<Copy> copies;

    public Equipment() {
        copies = new ArrayList<>();
    }

    public Equipment(int equipmentID, String connection, String specification, String name, List<Copy> copies) {
        this.equipmentID = equipmentID;
        this.connection = connection;
        this.specification = specification;
        this.name = name;
        this.copies = copies;
    }

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(int equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setCopies(int copiesNo) {

        for (int i = 0; i < copiesNo; i++) {
            this.copies.add(new Copy());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Equipment{" + "equipmentID=" + equipmentID + ", name=" + name + '}' + "copies" + copies.toString();
    }

}
