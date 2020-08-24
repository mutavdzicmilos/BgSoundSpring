/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rs.ac.bg.silab.bgsound.entity.Producer;

/**
 *
 * @author Milos
 */
@Component
public class ProducerValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Producer.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        /*   Rent rent = (Rent) target;
        System.out.println("Validating rent: " + rent);

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.name.empty", "Morate uneti ime");
        //  ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "client.surname.empty", "Morate uneti prezime");
        if (errors.hasErrors()) {
            return;
        }*/    }

}
