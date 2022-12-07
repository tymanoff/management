package ru.codemark.management.mapper;

import org.mapstruct.Mapper;
import ru.codemark.management.dto.PersonDto;
import ru.codemark.management.dto.request.RequestPerson;
import ru.codemark.management.dto.request.RequestUpdatePerson;
import ru.codemark.management.dto.response.ResponsePerson;
import ru.codemark.management.entity.Person;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDto requestPersonDtoToPersonDto(RequestPerson requestPerson);

    PersonDto requestUpdatePersonDtoToPersonDto(RequestUpdatePerson request);

    Person personDtoToPerson(PersonDto personDto);

    PersonDto personToPersonDto(Person person);

    List<PersonDto> listPersonToListPersonDto(Iterable<Person> personIterable);

    List<ResponsePerson> listPersonDtoToListResponsePerson(Iterable<PersonDto> personDtoIterable);

    ResponsePerson personDtoToResponsePerson(PersonDto getPerson);
}
