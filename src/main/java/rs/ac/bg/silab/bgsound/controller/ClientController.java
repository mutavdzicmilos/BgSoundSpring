package rs.ac.bg.silab.bgsound.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rs.ac.bg.silab.bgsound.entity.Client;
import rs.ac.bg.silab.bgsound.service.ClientService;
import rs.ac.bg.silab.bgsound.validator.ClientValidator;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    private final ClientService serviceClient;
    private final ClientValidator clientValidator;

    @Autowired
    public ClientController(ClientService serviceClient, ClientValidator clientValidator) {
        this.serviceClient = serviceClient;
        this.clientValidator = clientValidator;
    }

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(clientValidator);
    }

    @GetMapping
    public String home() {
        System.out.println("====================================================================");
        System.out.println("====================   ClientController: home()    ===================");
        System.out.println("====================================================================");
        return "client/home";
    }

    @GetMapping(value = "add")
    public ModelAndView add() {
        System.out.println("====================================================================");
        System.out.println("====================   ClientController: add()     ===================");
        System.out.println("====================================================================");

        ModelAndView modelAndView = new ModelAndView("client/add");
        return modelAndView;
    }

    @GetMapping(value = "all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("client/all");
        modelAndView.addObject("message", "All clients!");
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/view")
    public ModelAndView view(@PathVariable(name = "numberId") int numberId) {
        ModelAndView modelAndView = new ModelAndView("client/view");
        modelAndView.addObject("client", serviceClient.returnByID(numberId));
        return modelAndView;
    }

    @GetMapping(value = "/{numberId}/delete")
    public ModelAndView delete(@PathVariable(name = "numberId") int numberId) {
        System.out.println("Delete..." + numberId);
        Client cl= serviceClient.returnByID(numberId);
        if(cl.getRents().size()==0){
        serviceClient.deleteClient(cl);
            System.out.println("gde sam");
                
         ModelAndView modelAndView = new ModelAndView("redirect:/client/all");
        modelAndView.addObject("message", "Client " + numberId + " is deleted!");
        return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("redirect:/client/all");
        modelAndView.addObject("message", "Client " + numberId + "has rents!");
        return modelAndView;
    }

    @PostMapping(value = "save")
    public String save(@Validated @ModelAttribute(name = "clientObject") Client client, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("===================================================================================");
        System.out.println("====================   ClientController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(client);
        if (result.hasErrors()) {
            model.addAttribute("message", "One or more fields are invalid!");
            model.addAttribute("clientObject", client);
            return "client/add";
        } else {
            serviceClient.saveClient(client);
            redirectAttributes.addFlashAttribute("message", "Client is saved!");
            return "redirect:/client/add";
        }
    }

    //pozabavi se porukom
    @PostMapping(value = "/{numberId}/saved")
    public String saved(@ModelAttribute(name = "client") @Validated Client client, BindingResult result, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes, @PathVariable(name = "numberId") int numberId) {
        System.out.println("===================================================================================");
        System.out.println("====================   ClientController: save(@ModelAttribute)    ===================");
        System.out.println("===================================================================================");
        System.out.println(client);
        if (result.hasErrors()) {
            model.addAttribute("message", "One or more fields are invalid");
            model.addAttribute("client", client);
            return "client/view";
        } else {
            serviceClient.saveClient(client);
           model.addAttribute("message", "Client is saved");
            return "client/view";
        }
    }

    @ModelAttribute(name = "clients")
    private List<Client> getClients() {
        return serviceClient.returnAllClients();
    }

    @ModelAttribute(name = "client")
    private Client clientNew() {
        return new Client();
    }

    @ModelAttribute(name = "clientObject")
    private Client clientobj() {
        return new Client();
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
