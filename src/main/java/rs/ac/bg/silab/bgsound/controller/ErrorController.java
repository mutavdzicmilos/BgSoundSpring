package rs.ac.bg.silab.bgsound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {

  
    @GetMapping(value = "globalException")
    public ModelAndView getGlobalError(
            @ModelAttribute("errorObj") Exception exception,
            @ModelAttribute("errorMessage") String errorMessage
    ) {

        System.out.println("=======================================");
        System.out.println("errorMessage: " + errorMessage);
        System.out.println("=======================================");

        ModelAndView modelAndView = new ModelAndView("error/globalException");
        modelAndView.addObject("errorMessage", errorMessage);
        modelAndView.addObject("errorObj", exception);

        return modelAndView;
    }
}
