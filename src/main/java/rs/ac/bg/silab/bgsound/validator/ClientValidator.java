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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.name.empty", "Morate uneti ime");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "client.surname.empty", "Morate uneti prezime");

        if (errors.hasErrors()) {
            return;
        }

        if (client.getName().length() < 2) {
            errors.rejectValue("name", "client.name.size", "Ime mora imati najmanje 2 a najvise 30 znakova");
        }
        
    }
}
