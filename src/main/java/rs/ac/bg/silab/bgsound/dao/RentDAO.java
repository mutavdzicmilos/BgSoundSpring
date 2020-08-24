/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.dao;

import java.util.List;
import rs.ac.bg.silab.bgsound.entity.Rent;

/**
 *
 * @author Milos
 */
public interface RentDAO {

    public void discharge(int rent);

    public List<Rent> getAll();

    public Rent getByID(int id);

    public void save(Rent rent);
}
