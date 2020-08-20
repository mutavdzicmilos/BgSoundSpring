/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    private Date dateFrom;
    private Date dateTo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientid", referencedColumnName = "clientid")
    private Client client;
    @OneToMany
    @JoinColumn(name = "rentid", referencedColumnName = "rentID")
    private List<Copy> copies;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "username")
    private Worker worker;

}
