/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.service;

import java.util.List;
import rs.ac.bg.silab.bgsound.entity.Copy;

/**
 *
 * @author Milos
 */
public interface CopyService {

    Copy returnByID(int id);

    void deleteCopy(int copy);

    void updateCopy(Copy copy);

    List<Copy> getAll();
}
