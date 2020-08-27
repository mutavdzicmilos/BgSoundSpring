/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rs.ac.bg.silab.bgsound.entity.Copy;

/**
 *
 * @author Milos
 */
@Component
public class CopyValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
 return Copy.class.equals(type);  
    }

    @Override
    public void validate(Object o, Errors errors) {
    Copy copy = (Copy) o;

    System.out.println("Validating copy: " + copy);
        
        
        
    }
    
}
