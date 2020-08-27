package rs.ac.bg.silab.bgsound.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import rs.ac.bg.silab.bgsound.entity.Equipment;

@Component
public class EquipmentValidator
        implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Equipment.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Equipment equipment = (Equipment) target;

        System.out.println("Validating equipment: " + equipment);
        if (equipment.getName().length() < 2) {
            errors.rejectValue("name", "equipment.name.size", "2 letters minimum");
        }
        if (equipment.getSpecification().length() < 2) {
            errors.rejectValue("specification", "equipment.specification.size", "2 letters minimum");
        }
        if (equipment.getConnection().length() < 2) {
            errors.rejectValue("connection", "client.connection.size", "2 letters minimum");
        }
        
        if (errors.hasErrors()) {
            return;
        }

    }
}
