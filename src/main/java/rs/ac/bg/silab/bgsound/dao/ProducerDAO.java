/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.dao;

import java.util.List;
import rs.ac.bg.silab.bgsound.entity.EquipmentType;
import rs.ac.bg.silab.bgsound.entity.Producer;

/**
 *
 * @author Milos
 */
public interface ProducerDAO {

    public void save(Producer producer);

    public List<Producer> getAll();

    public List<EquipmentType> getAllTypes();
}
