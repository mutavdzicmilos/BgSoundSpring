/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author
 */
@Entity
@Table(name = "rent")
public class Rent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentID")
    private int rentID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateTo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "clientid")
    private Client client;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "rentid", referencedColumnName = "rentID")
    private List<Copy> copies;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userID", referencedColumnName = "username")
    private Worker worker;

    public int getRentID() {
        return rentID;
    }

    public void setRentID(int rentID) {
        this.rentID = rentID;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;

    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public void setCopies(int copiesNo) {
        if (copies == null) {
            copies = new ArrayList<>();
        }
        for (int i = 0; i < copiesNo; i++) {
            Copy c = new Copy();
            this.copies.add(c);
        }
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Rent() {
        this.copies = new ArrayList<>();
    }

    public Rent(int rentID, Date dateFrom, Date dateTo, Client client, List<Copy> copies, Worker worker) {
        this.rentID = rentID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.client = client;
        this.copies = copies;
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Rent{" + "rentID=" + rentID + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", client=" + client + ", copies=" + copies + ", worker=" + worker + '}';
    }

}
