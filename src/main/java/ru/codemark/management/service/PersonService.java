package ru.codemark.management.service;

import ru.codemark.management.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto savePerson(PersonDto personDto);

    List<PersonDto> getAllPersons();

    void deletePerson(Long id);

    PersonDto getPerson(Long id);
}
