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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rs.ac.bg.silab.bgsound.entity.Copy;
import rs.ac.bg.silab.bgsound.entity.Equipment;
import rs.ac.bg.silab.bgsound.service.CopyService;
import rs.ac.bg.silab.bgsound.validator.CopyValidator;

/**
 *
 * @author Milos
 */
@Controller
@RequestMapping(value = "/copy")
public class CopyController {

    private final CopyService serviceCopy;
    private final CopyValidator copyValidator;

    @Autowired
    public CopyController(CopyService serviceCopy, CopyValidator copyValidator) {
        this.serviceCopy = serviceCopy;
        this.copyValidator = copyValidator;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(copyValidator);
    }

    @GetMapping(value = "/{copyId}/view")
    public ModelAndView viewCopy(@PathVariable(name = "copyId") int copyId) {
        ModelAndView modelAndView = new ModelAndView("copy/view");
        modelAndView.addObject("message", "Copy " + copyId);
        Copy c = serviceCopy.returnByID(copyId);
        modelAndView.addObject("copy", c);
        return modelAndView;
    }
  //pozabavi se porukom
    @PostMapping(value = "/{numberId}/saved")
    public String saved(@ModelAttribute(name = "copy") @Validated Copy copy, BindingResult result, Model model, RedirectAttributes redirectAttributes, @PathVariable(name = "numberId") int numberId) {
        System.out.println("===================================================================================");
        System.out.println("====================   CopyController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(copy);
        copy.setCopyID(numberId);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("copy", copy);
            return numberId + "/view";
        } else {
            serviceCopy.updateCopy(copy);
            redirectAttributes.addFlashAttribute("message", "Copy is saved");
            return "redirect:/copy/" + numberId + "/view";
        }
    }
    
    
    @GetMapping(value = "/{numberId}/delete")
    public ModelAndView delete(@PathVariable(name = "numberId") int numberId) {
        System.out.println("Delete..." + numberId+"\n\n\n\n\n");
        serviceCopy.deleteCopy(numberId);
        ModelAndView modelAndView = new ModelAndView("redirect:/equipment/all");
        modelAndView.addObject("message", "Copy " + numberId + " is deleted!");
        return modelAndView;
    }
}
