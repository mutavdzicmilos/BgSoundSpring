/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.service;

import rs.ac.bg.silab.bgsound.entity.Worker;

/**
 *
 * @author Milos
 */
public interface WorkerService {
     public Worker getWorker(String username);
}
