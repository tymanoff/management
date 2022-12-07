package ru.codemark.management.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codemark.management.dto.request.RequestPerson;
import ru.codemark.management.dto.request.RequestUpdatePerson;
import ru.codemark.management.dto.response.ResponseAllPerson;
import ru.codemark.management.dto.response.ResponsePerson;
import ru.codemark.management.dto.response.ResponseResult;
import ru.codemark.management.facade.PersonFacade;

import javax.jws.WebService;

@WebService(
        serviceName = "Management",
        portName = "ManagementPort",
        targetNamespace = "http://service.ws.management/",
        endpointInterface = "ru.codemark.management.endpoint.ManagementEndpoint")

@Service
@RequiredArgsConstructor
public class ManagementEndpointImpl implements ManagementEndpoint {

    private final PersonFacade personFacade;

    @Override
    public ResponseResult createPerson(RequestPerson request) {
        return personFacade.createPerson(request);
    }

    @Override
    public ResponseResult updatePerson(RequestUpdatePerson request) {
        return personFacade.updatePerson(request);
    }

    @Override
    public ResponsePerson getPerson(Long id) {
        return personFacade.getPerson(id);
    }

    @Override
    public ResponseAllPerson getAllPersons() {
        return personFacade.getAllPersons();
    }

    @Override
    public void deletePerson(Long id) {
        personFacade.deletePerson(id);
    }

}
