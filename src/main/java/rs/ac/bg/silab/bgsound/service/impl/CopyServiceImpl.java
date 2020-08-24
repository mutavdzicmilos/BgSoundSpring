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
import rs.ac.bg.silab.bgsound.dao.ClientDAO;
import rs.ac.bg.silab.bgsound.dao.CopyDAO;
import rs.ac.bg.silab.bgsound.entity.Copy;
import rs.ac.bg.silab.bgsound.service.CopyService;

/**
 *
 * @author Milos
 */
@Service
@Transactional
public class CopyServiceImpl implements CopyService {

    CopyDAO copyDAO;

    @Autowired
    public CopyServiceImpl(CopyDAO copyDAO) {
        this.copyDAO = copyDAO;
    }

    @Override
    public Copy returnByID(int id) {
        return copyDAO.returnByID(id);
    }

    @Override
    public void deleteCopy(int copy) {
        copyDAO.deleteCopy(copy);
    }

    @Override
    public void updateCopy(Copy copy) {
        copyDAO.updateCopy(copy);
    }

    @Override
    public List<Copy> getAll() {
        return copyDAO.getAll();
    }
}
