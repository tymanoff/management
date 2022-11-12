package ru.codemark.management.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codemark.management.dto.PersonDto;
import ru.codemark.management.entity.Person;
import ru.codemark.management.exception.PersonNotFoundException;
import ru.codemark.management.mapper.PersonMapper;
import ru.codemark.management.repository.PersonRepository;
import ru.codemark.management.service.PersonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto savePerson(PersonDto personDto) {
        Person person = personMapper.personDtoToPerson(personDto);
        Person savedPerson = personRepository.save(person);
        return personMapper.personToPersonDto(savedPerson);
    }

    @Override
    public PersonDto getPerson(Long id) {
        Person person = personRepository
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No user with id: " + id));

        return personMapper.personToPersonDto(person);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> allPerson = personRepository.findAll();
        return personMapper.listPersonToListPersonDto(allPerson);
    }

    @Override
    public void deletePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        } else {
            throw new PersonNotFoundException("No user with id: " + id);
        }
    }
}
