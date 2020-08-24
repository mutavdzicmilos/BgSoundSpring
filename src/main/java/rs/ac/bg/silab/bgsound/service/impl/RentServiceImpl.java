/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.silab.bgsound.dao.RentDAO;
import rs.ac.bg.silab.bgsound.entity.Rent;
import rs.ac.bg.silab.bgsound.service.RentService;

/**
 *
 * @author Milos
 */
@Service
@Transactional
public class RentServiceImpl implements RentService {

    RentDAO rentDAO;

    @Autowired
    public RentServiceImpl(RentDAO rentDAO) {
        this.rentDAO = rentDAO;
    }

    @Override
    public void discharge(int rent) {
        rentDAO.discharge(rent);
    }

    @Override
    public List<Rent> getAll() {
        return rentDAO.getAll();
    }

    @Override
    public Rent getByID(int id){
        return rentDAO.getByID(id);
    }

    @Override
    public void save(Rent rent)  {
        System.out.println("u servisu sam"+ rent+"\n\n\n\n");
        rentDAO.save(rent);
    }

}
