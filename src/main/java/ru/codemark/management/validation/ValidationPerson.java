package ru.codemark.management.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.codemark.management.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidationPerson {
    public List<String> validationRequest(PersonDto personDto) {
        List<String> errors = new ArrayList<>();
        if (StringUtils.isBlank(personDto.getName())) {
            errors.add("Name required");
        }

        if (StringUtils.isBlank(personDto.getLogin())) {
            errors.add("Login required");
        }

        String passwordCheck = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{3,}";
        if (StringUtils.isBlank(personDto.getPassword())) {
            errors.add("Password required");
        } else if (!personDto.getPassword().matches(passwordCheck)) {
            errors.add("Password at least 3 characters, contains an upper case letter and a number");
        }

        return errors;
    }
}
