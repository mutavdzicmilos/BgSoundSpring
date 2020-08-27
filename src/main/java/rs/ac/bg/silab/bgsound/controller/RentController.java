/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rs.ac.bg.silab.bgsound.entity.Client;
import rs.ac.bg.silab.bgsound.entity.Copy;
import rs.ac.bg.silab.bgsound.entity.Rent;
import rs.ac.bg.silab.bgsound.service.ClientService;
import rs.ac.bg.silab.bgsound.service.CopyService;
import rs.ac.bg.silab.bgsound.service.RentService;
import rs.ac.bg.silab.bgsound.service.WorkerService;

/**
 *
 * @author Milos
 */
@Controller
@RequestMapping(value = "/rent")
public class RentController {

    private final RentService serviceRent;
    private final CopyService copyService;
    private final ClientService clientService;
    private final WorkerService workerService;

    @Autowired
    public RentController(RentService serviceRent,CopyService copyService, ClientService clientService, WorkerService serviceWorker) {
        this.serviceRent = serviceRent;
        this.copyService = copyService;
        this.clientService = clientService;
        this.workerService = serviceWorker;
    }


    @GetMapping(value = "rent")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   RentController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("rent/rent");
        modelAndView.addObject("rentObject", new Rent());
        return modelAndView;
    }

    @GetMapping(value = "discharge")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("rent/discharge");
        modelAndView.addObject("message", "Discharging rents page!");
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/delete")
    public ModelAndView delete(@PathVariable(name = "numberId") int numberId) {
        System.out.println("Delete..." + numberId);
        serviceRent.discharge(numberId);
        ModelAndView modelAndView = new ModelAndView("redirect:/rent/discharge");
        modelAndView.addObject("message", "Rent " + numberId + " is discharged!");
        return modelAndView;
    }

    @PostMapping(value = "save")
    public String save(@ModelAttribute(name = "rent") @Validated Rent rent, BindingResult result, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   RentController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        ModelAndView modelAndView = new ModelAndView();
        rent.setWorker(workerService.getWorker(request.getUserPrincipal().getName()));

        System.out.println("\n\n\n"+rent+"\n\n\n\n\n");
            System.out.println(request.getParameterNames());
        
        
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            return "redirect:/rent/rent";
        } else {
            serviceRent.save(rent);
            redirectAttributes.addFlashAttribute("message", "Rent is saved");
            return "redirect:/rent/rent";
        }
    }

    @ModelAttribute(name = "copiesAll")
    private List<Copy> getCopies() {
        return copyService.getAll();
    }

    @ModelAttribute(name = "clients")
    private List<Client> getClients() {

        return clientService.returnAllClients();
    }
   
    
    
    @ModelAttribute(name = "rentsAll")
    private List<Rent> getRents() {
        return serviceRent.getAll();
    }
}
