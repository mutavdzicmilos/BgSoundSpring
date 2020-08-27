package rs.ac.bg.silab.bgsound.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import rs.ac.bg.silab.bgsound.entity.Client;
@Component
public class ClientValidator
        implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       Client client = (Client) target;

        System.out.println("Validating client: " + client);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.name.empty", "is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "client.surname.empty", "is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "JMBG", "client.JMBG.empty", "is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "client.phone.empty", "is required");
        

        if (errors.hasErrors()) {
            return;
        }

        if (client.getName().length() < 2) {
            errors.rejectValue("name", "client.name.size", "2 letters minimum");
        }
        if (client.getSurname().length() < 2) {
            errors.rejectValue("surname", "client.name.size", "2 letters minimum");
        }
        
        if (!client.getJMBG().matches("[0-9]{13}")) {
            errors.rejectValue("JMBG", "client.JMBG.size", "13 numbers needed");
        }
      
        if (!client.getPhone().matches("(\\+[0-9]{3}|0)[0-9]{5,10}")) {
            errors.rejectValue("phone", "client.phone.size", "Only numbers needed");
        }
        
        
    }
}
