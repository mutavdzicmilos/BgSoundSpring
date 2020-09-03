/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rs.ac.bg.silab.bgsound.entity.Rent;

/**
 *
 * @author Milos
 */
@Component
public class RentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
       return Rent.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       Rent rent = (Rent) target;
        System.out.println("Validating rent: " + rent);
        if(rent.getDateTo()==null){
        errors.rejectValue("dateTo","rent.dateTo.empty","dateTo cant be null" );
        }
        if(rent.getDateFrom()==null){
        errors.rejectValue("dateFrom","rent.dateFrom.empty","dateFrom cant be null" );
        }
        
        if(errors.getAllErrors().size()>1){
            return;
        }
        if(rent.getDateTo().getTime()-rent.getDateFrom().getTime()<0){
           errors.rejectValue("dateTo","rent.dateTo.empty","must be after" );
               errors.rejectValue("dateFrom","rent.dateFrom.empty","must be before" );
        }
    }
}
