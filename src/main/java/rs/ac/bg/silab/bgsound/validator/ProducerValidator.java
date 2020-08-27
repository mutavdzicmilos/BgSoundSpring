/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.silab.bgsound.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
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
        Producer prod = (Producer) o;

        System.out.println("Validating producer: " + o);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "producer.name.empty", "is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "producer.email.empty", "is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "producer.phone.empty", "is required");

        if (errors.hasErrors()) {
            return;
        }
    }
}
