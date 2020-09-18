package rs.ac.bg.silab.bgsound.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rs.ac.bg.silab.bgsound.entity.Copy;
import rs.ac.bg.silab.bgsound.entity.Equipment;
import rs.ac.bg.silab.bgsound.entity.EquipmentType;
import rs.ac.bg.silab.bgsound.entity.Producer;
import rs.ac.bg.silab.bgsound.service.EquipmentService;
import rs.ac.bg.silab.bgsound.service.ProducerService;
import rs.ac.bg.silab.bgsound.validator.EquipmentValidator;

@Controller
@RequestMapping(value = "/equipment")
public class EquipmentController {

    private final EquipmentService serviceEquipment;
    private final EquipmentValidator equipmentValidator;
    private final ProducerService producerService;

    @Autowired
    public EquipmentController(EquipmentService serviceEquipment, EquipmentValidator equipmentValidator, ProducerService producerService) {
        this.serviceEquipment = serviceEquipment;
        this.equipmentValidator = equipmentValidator;
        this.producerService = producerService;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(equipmentValidator);
    }

    @GetMapping(value = "/{number}/picture")
    public void viewCopy(@PathVariable(name = "number") int number, HttpServletResponse response) throws IOException {
        if (serviceEquipment.getByID(number).getEquipmentPicture() != null) {
            InputStream in = new ByteArrayInputStream(serviceEquipment.getByID(number).getEquipmentPicture());
            BufferedImage imgFromDb = ImageIO.read(in);
            response.setContentType("image/png");
            ImageIO.write(imgFromDb, "png", response.getOutputStream());
        }
    }

    @GetMapping
    public String home() {
        System.out.println("====================================================================");
        System.out.println("====================   EquipmentController: home()    ===================");
        System.out.println("====================================================================");
        return "equipment/home";
    }

    @GetMapping(value = "addproducer")
    public ModelAndView getProd() {
        ModelAndView modelAndView = new ModelAndView("producer/addproducer");
        modelAndView.addObject("message", "Add producer!");
        return modelAndView;
    }

    @GetMapping(value = "add")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   EquipmentController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("equipment/add");
        modelAndView.addObject("equipmentObject", new Equipment());
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
        System.out.println("\n\n\n\n\n" + serviceEquipment.getByID(numberId) + "\n\n\n\n\n\n");
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/delete")
    public ModelAndView delete(@PathVariable(name = "numberId") int numberId) {
        System.out.println("Delete..." + numberId);
        Equipment e = serviceEquipment.getByID(numberId);
        for (Copy c : e.getCopies()) {
            if (c.getRentid() != null) {
                ModelAndView modelAndView = new ModelAndView("redirect:/equipment/all");
                modelAndView.addObject("message", "Equipment " + numberId + " cant be deleted!");
                return modelAndView;
            }
        }
        serviceEquipment.delete(numberId);
        ModelAndView modelAndView = new ModelAndView("redirect:/equipment/all");
        modelAndView.addObject("message", "Equipment " + numberId + " is deleted!");
        return modelAndView;
    }

    @PostMapping(value = "save")
    public String save(@Validated @ModelAttribute(name = "equipmentObject") Equipment equipment, BindingResult result, MultipartHttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   EquipmentController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(equipment + "\n\n\n\n");
        if (result.hasErrors()) {
            model.addAttribute("message", "One or more fields are invalid");
            model.addAttribute("equipmentObject", equipment);
            return "equipment/add";
        } else {
            int no = Integer.valueOf(request.getParameter("copiesNo"));
            equipment.setCopies(no);
            try {
                MultipartFile imageFile = request.getFile("imageFile");
                equipment.setEquipmentPicture(imageFile.getBytes());
            } catch (Exception ex) {

            }
            serviceEquipment.saveEquipment(equipment);
            redirectAttributes.addFlashAttribute("message", "Equipment is saved");
            return "redirect:/equipment/add";
        }
    }

    @PostMapping(value = "/{numberId}/saved")
    public String saved(@ModelAttribute(name = "equipment") @Validated Equipment equipment, BindingResult result, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes, @PathVariable(name = "numberId") int numberId) {
        System.out.println("===================================================================================");
        System.out.println("====================   EquipmentController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(equipment);
        int no = Integer.valueOf(request.getParameter("copiesNo"));
        equipment.setCopies(no);
        if (result.hasErrors()) {
            model.addAttribute("message", "Error Saving: One or more fields are invalid");
            model.addAttribute("equipment", equipment);
            return "equipment/all";
        } else {
            serviceEquipment.changeEquipment(equipment);
            redirectAttributes.addFlashAttribute("message", "Equipment is saved");
            return "redirect:/equipment/all";
        }
    }

    @ModelAttribute(name = "equipments")
    private List<Equipment> getEquipment() {
        List<Equipment> equip = serviceEquipment.getAll();

        return equip;
    }

    @ModelAttribute(name = "eqNo")
    private int getC() {
        return 0;
    }

    @ModelAttribute(name = "producers")
    private List<Producer> getProducers() {
        return producerService.getAll();
    }

    @ModelAttribute(name = "types")
    private List<EquipmentType> getTypes() {
        return producerService.getAllTypes();
    }

    @ModelAttribute(name = "producerid")
    private int producerString() {
        return 0;
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(NullPointerException nullPointerException, RedirectAttributes redirectAttributes) {

        System.out.println("====================================================================");
        System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
        System.out.println("====================================================================");

        redirectAttributes.addFlashAttribute("errorMessage", nullPointerException.getMessage());
        redirectAttributes.addFlashAttribute("errorObj", nullPointerException);

        return "redirect:/error/globalException";
    }
}
