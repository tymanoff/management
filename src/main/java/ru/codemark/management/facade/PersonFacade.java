package ru.codemark.management.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.codemark.management.dto.PersonDto;
import ru.codemark.management.dto.RoleDto;
import ru.codemark.management.dto.request.RequestPerson;
import ru.codemark.management.dto.request.RequestUpdatePerson;
import ru.codemark.management.dto.response.ResponseAllPerson;
import ru.codemark.management.dto.response.ResponsePerson;
import ru.codemark.management.dto.response.ResponseResult;
import ru.codemark.management.dto.response.ResponseRole;
import ru.codemark.management.exception.NotFoundException;
import ru.codemark.management.mapper.PersonMapper;
import ru.codemark.management.mapper.RoleMapper;
import ru.codemark.management.service.PersonService;
import ru.codemark.management.service.RoleService;
import ru.codemark.management.validation.ValidationPerson;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PersonFacade {

    private final PersonService personService;
    private final RoleService roleService;
    private final PersonMapper personMapper;
    private final RoleMapper roleMapper;
    private final ValidationPerson validationPerson;

    public ResponseResult createPerson(RequestPerson request) {
        ResponseResult resultCreatePerson = new ResponseResult();
        PersonDto personDto = personMapper.requestPersonDtoToPersonDto(request);
        Set<RoleDto> roleDto = roleMapper.setRequestRoleToSetRoleDto(request.getRequestRoles());

        List<String> validationRequest = validationPerson.validationRequest(personDto);
        if (!validationRequest.isEmpty()) {
            resultCreatePerson.setErrors(validationRequest);
            return resultCreatePerson;
        }

        PersonDto savePerson = personService.savePerson(personDto);
        Set<RoleDto> role = roleService.createRole(roleDto);
        savePerson.setRoles(role);
        personService.savePerson(savePerson);

        resultCreatePerson.setSuccess(true);
        return resultCreatePerson;
    }

    public ResponseResult updatePerson(RequestUpdatePerson request) {
        ResponseResult resultUpdatePerson = new ResponseResult();
        PersonDto personDto = personMapper.requestUpdatePersonDtoToPersonDto(request);

        List<String> validationRequest = validationPerson.validationRequest(personDto);
        if (!validationRequest.isEmpty()) {
            resultUpdatePerson.setErrors(validationRequest);
            return resultUpdatePerson;
        }

        personService.getPerson(request.getId());
        PersonDto savePerson = personService.savePerson(personDto);

        resultUpdatePerson.setSuccess(savePerson != null);
        return resultUpdatePerson;
    }

    public ResponsePerson getPerson(Long id) {
        if (id == null) {
            throw new NotFoundException("Id is null");
        } else {
            PersonDto getPerson = personService.getPerson(id);
            Set<ResponseRole> roles = roleMapper.setRoleDtoToSetResponseRole(getPerson.getRoles());

            ResponsePerson responsePerson = personMapper.personDtoToResponsePerson(getPerson);
            responsePerson.setResponseRoles(roles);
            return responsePerson;
        }
    }

    public ResponseAllPerson getAllPersons() {
        List<PersonDto> allPerson = personService.getAllPersons();

        ResponseAllPerson responseAllPerson = new ResponseAllPerson();
        responseAllPerson.setAllPerson(personMapper.listPersonDtoToListResponsePerson(allPerson));
        return responseAllPerson;
    }

    public void deletePerson(Long id) {
        if (id == null) {
            throw new NotFoundException("Id is null");
        } else {
            personService.deletePerson(id);
        }
    }
}
