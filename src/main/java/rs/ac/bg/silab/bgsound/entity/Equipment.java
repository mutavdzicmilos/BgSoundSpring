/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author FON
 */
@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "equipmentID")
    private Integer equipmentID;
    private String name;
    private String connection;
    private String specification;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    private byte[] equipmentPicture;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "equipment", cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Copy> copies;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "equipmenttypeid", referencedColumnName = "equipmenttypeid")
    private EquipmentType type;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "producerID", referencedColumnName = "producerID")
    private Producer producer;

    public Equipment(Integer equipmentID, String name, String connection, String specification, byte[] equipmentPicture, List<Copy> copies, EquipmentType type, Producer producer) {
        this.equipmentID = equipmentID;
        this.name = name;
        this.connection = connection;
        this.specification = specification;
        this.equipmentPicture = equipmentPicture;
        this.copies = copies;
        this.type = type;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Equipment{" + "equipmentID=" + equipmentID + ", name=" + name + ", connection=" + connection + ", specification=" + specification + ", equipmentPicture=" + equipmentPicture + ", copies=" + copies + ", type=" + type + ", producer=" + producer + '}';
    }

 
    
    public Equipment() {
        copies = new ArrayList<>();
        producer = new Producer();
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
            Copy c = new Copy();
            c.setEquipment(this);
            this.copies.add(c);
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

    public void add(Copy copy) {
        if (copies == null) {
            copies = new ArrayList<>();
        }
        copies.add(copy);
        copy.setEquipment(this);
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public byte[] getEquipmentPicture() {
        return equipmentPicture;
    }

    public void setEquipmentPicture(byte[] equipmentPicture) {
        this.equipmentPicture = equipmentPicture;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }
}
