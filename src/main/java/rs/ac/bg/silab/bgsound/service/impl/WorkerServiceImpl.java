/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.silab.bgsound.dao.WorkerDAO;
import rs.ac.bg.silab.bgsound.entity.Worker;
import rs.ac.bg.silab.bgsound.service.WorkerService;

/**
 *
 * @author Milos
 */
@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

    WorkerDAO workerDAO;

    @Autowired
    public WorkerServiceImpl(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @Override
    public Worker getWorker(String username) {
        return workerDAO.getWorker(username);
    }

}
