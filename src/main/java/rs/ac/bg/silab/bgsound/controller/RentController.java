/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Milos
 */

@Controller
@RequestMapping(value = "/rent")
public class RentController {
    
    @GetMapping(value = "rent")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   ClientController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("rent/rent");
        return modelAndView;
    }

    @GetMapping(value = "discharge")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("rent/discharge");
        modelAndView.addObject("message", "Discharging rents page!");
        return modelAndView;
    }

}
