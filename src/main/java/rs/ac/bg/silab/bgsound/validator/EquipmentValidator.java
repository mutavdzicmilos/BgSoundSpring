package rs.ac.bg.silab.bgsound.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import rs.ac.bg.silab.bgsound.entity.Client;
import rs.ac.bg.silab.bgsound.entity.Equipment;

@Component
public class EquipmentValidator
        implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // return Equipment.class.equals(clazz);
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Equipment eq = (Equipment) target;

        System.out.println("Validating equipment: " + eq);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "eq.name.empty", "Morate uneti ime");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "connection", "eq.connection.empty", "Morate uneti konekciju");

        if (errors.hasErrors()) {
            return;
        }

        if (eq.getName().length() < 2) {
            errors.rejectValue("name", "eq.name.size", "Ime mora imati najmanje 2 a najvise 30 znakova");
        }

    }
}
