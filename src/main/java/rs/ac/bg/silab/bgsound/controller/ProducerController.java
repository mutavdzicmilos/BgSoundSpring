/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rs.ac.bg.silab.bgsound.entity.Producer;
import rs.ac.bg.silab.bgsound.service.ProducerService;
import rs.ac.bg.silab.bgsound.validator.ProducerValidator;

/**
 *
 * @author Milos
 */
@Controller
@RequestMapping(value = "/producer")
public class ProducerController {

    private final ProducerService producerService;
    private final ProducerValidator producerValidator;

    @Autowired
    public ProducerController(ProducerService producerService, ProducerValidator producerValidator) {
        this.producerService = producerService;
        this.producerValidator = producerValidator;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(producerValidator);
    }

    @PostMapping(value = "save")
    public String save(@ModelAttribute(name = "producerObject") @Validated Producer producer, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   ProducerController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(producer);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("message", "One or more fields are invalid");
            model.addAttribute("producerObject", producer);
            return "producer/add";
        } else {
            producerService.save(producer);
            model.addAttribute("message", "Producer is saved");
            return "producer/add";
        }
    }

    
   
    @GetMapping(value = "add")
    public ModelAndView getProd() {
        ModelAndView modelAndView = new ModelAndView("producer/add");
        modelAndView.addObject("message", "Add producer!");
        return modelAndView;
    }

    @ModelAttribute(name="producerObject")
    private Producer getProducer() {
        return new Producer();
    }
}
