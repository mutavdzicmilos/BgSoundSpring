package rs.ac.bg.silab.bgsound.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import rs.ac.bg.silab.bgsound.service.EquipmentService;
import rs.ac.bg.silab.bgsound.validator.EquipmentValidator;

@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {

    private final EquipmentService serviceEquipment;
    private final EquipmentValidator equipmentValidator;

    @Autowired
    public EquipmentController(EquipmentService serviceEquipment, EquipmentValidator equipmentValidator) {
        this.serviceEquipment = serviceEquipment;
        this.equipmentValidator = equipmentValidator;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(equipmentValidator);
    }

    @GetMapping
    public String home() {
        System.out.println("====================================================================");
        System.out.println("====================   EquipmentController: home()    ===================");
        System.out.println("====================================================================");
        return "equipment/home";
    }

    @GetMapping(value = "add")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   EquipmentController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("equipment/add");
        return modelAndView;
    }

    @GetMapping(value = "all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("equipment/all");
        modelAndView.addObject("message", "All equipment!");
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/view")
    public ModelAndView view(@PathVariable(name = "numberId") int numberId) {
        ModelAndView modelAndView = new ModelAndView("equipment/view");
        modelAndView.addObject("message", "Equipment " + numberId + "!");
        modelAndView.addObject("equipment", serviceEquipment.getByID(numberId));
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/delete")
    public ModelAndView delete(@PathVariable(name = "numberId") int numberId) {
        System.out.println("Delete..." + numberId);
        serviceEquipment.delete(numberId);
        ModelAndView modelAndView = new ModelAndView("redirect:/equipment/all");
        modelAndView.addObject("message", "Equipment " + numberId + " is deleted!");
        return modelAndView;
    }

    @PostMapping(value = "save")
    public String save(@ModelAttribute(name = "equipmentObject") @Validated Equipment equipment, BindingResult result, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   EquipmentController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(equipment);
        int no = Integer.valueOf(request.getParameter("copiesNo"));
        equipment.setCopies(no);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("equipmentObject", equipment);
            serviceEquipment.setEquipment(equipment);
            return "redirect:/equipment/add";
        } else {
            System.out.println("ovde sam");
            serviceEquipment.setEquipment(equipment);
            redirectAttributes.addFlashAttribute("message", "Equipment is saved");
            return "redirect:/equipment/add";
        }
    }

    @PostMapping(value = "/{numberId}/saved")
    public String saved(@ModelAttribute(name = "equipment") @Validated Equipment equipment, BindingResult result, Model model, RedirectAttributes redirectAttributes, @PathVariable(name = "numberId") int numberId) {
        System.out.println("===================================================================================");
        System.out.println("====================   EquipmentController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(equipment);
        equipment.setEquipmentID(numberId);
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            model.addAttribute("invalid", "One or more fields are invalid");
            model.addAttribute("equipment", equipment);
            return "equipment/all";
        } else {
            serviceEquipment.setEquipment(equipment);
            redirectAttributes.addFlashAttribute("message", "Equipment is saved");
            return "redirect:/equipment/all";
        }
    }

    @ModelAttribute(name = "equipments")
    private List<Equipment> getEquipment() {
        return serviceEquipment.getAll();
    }

    @ModelAttribute(name = "eqNo")
    private int getC() {
        return 0;
    }

    @ModelAttribute(name = "equipment")
    private Equipment equipmentNew() {
        return new Equipment();
    }

    @ModelAttribute(name = "equipmentObject")
    private Equipment equipmentObject() {
        return new Equipment();
    }

    @ExceptionHandler(NullPointerException.class)
    public String exceptionHandler(NullPointerException nullPointerException, RedirectAttributes redirectAttributes) {

        System.out.println("====================================================================");
        System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
        System.out.println("====================================================================");

        redirectAttributes.addFlashAttribute("errorMessage", nullPointerException.getMessage());
        redirectAttributes.addFlashAttribute("errorObj", nullPointerException);

        return "redirect:/error/globalException";
    }
}
