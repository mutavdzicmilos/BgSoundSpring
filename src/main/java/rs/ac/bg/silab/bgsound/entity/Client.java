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
 * @author FON
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "JMBG")
    private String JMBG;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clientid")
    private Integer clientID;
    @Column(name = "phone")
    private String phone;
  

    public Client() {
    }

    public Client(Integer clientID) {
        this.clientID = clientID;
    }

    public Client(String name, String surname, String JMBG, Integer clientID, String phone) {
        this.name = name;
        this.surname = surname;
        this.JMBG = JMBG;
        this.clientID = clientID;
        this.phone = phone;
    }

    public Client(String name, String surname, String JMBG, String phone) {
        this.name = name;
        this.surname = surname;
        this.JMBG = JMBG;
        this.phone = phone;
    }

    public Client(String name, String surname, Object object, Integer cid, Object object0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}
