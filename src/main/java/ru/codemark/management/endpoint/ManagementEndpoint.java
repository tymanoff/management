package ru.codemark.management.endpoint;

import ru.codemark.management.dto.request.RequestPerson;
import ru.codemark.management.dto.request.RequestUpdatePerson;
import ru.codemark.management.dto.response.ResponseAllPerson;
import ru.codemark.management.dto.response.ResponsePerson;
import ru.codemark.management.dto.response.ResponseResult;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://service.ws.management/", name = "ManagementEndpoint")
public interface ManagementEndpoint {


    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "Management",
            targetNamespace = "http://service.ws.createperson/",
            className = "service.ws.management.RequestManagement")
    @WebMethod(action = "urn:Management")
    @ResponseWrapper(
            localName = "ManagementResponse",
            targetNamespace = "http://service.ws.createperson/",
            className = "service.ws.management.ManagementResponse")
    ResponseResult createPerson(@WebParam(name = "CreatePerson", targetNamespace = "") RequestPerson request);

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "Management",
            targetNamespace = "http://service.ws.updateperson/",
            className = "service.ws.management.RequestManagement")
    @WebMethod(action = "urn:Management")
    @ResponseWrapper(
            localName = "ManagementResponse",
            targetNamespace = "http://service.ws.updateperson/",
            className = "service.ws.management.ManagementResponse")
    ResponseResult updatePerson(@WebParam(name = "UpdatePerson", targetNamespace = "") RequestUpdatePerson request);

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "Management",
            targetNamespace = "http://service.ws.getperson/",
            className = "service.ws.management.RequestManagement")
    @WebMethod(action = "urn:Management")
    @ResponseWrapper(
            localName = "ManagementResponse",
            targetNamespace = "http://service.ws.getperson/",
            className = "service.ws.management.ManagementResponse")
    ResponsePerson getPerson(@WebParam(name = "PersonId", targetNamespace = "") Long id);

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "Management",
            targetNamespace = "http://service.ws.persons/",
            className = "service.ws.management.RequestManagement")
    @WebMethod(action = "urn:Management")
    @ResponseWrapper(
            localName = "ManagementResponse",
            targetNamespace = "http://service.ws.persons/",
            className = "service.ws.management.ManagementResponse")
    ResponseAllPerson getAllPersons();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(
            localName = "Management",
            targetNamespace = "http://service.ws.deleteperson/",
            className = "service.ws.management.RequestManagement")
    @WebMethod(action = "urn:Management")
    @ResponseWrapper(
            localName = "ManagementResponse",
            targetNamespace = "http://service.ws.deleteperson/",
            className = "service.ws.management.ManagementResponse")
    void deletePerson(@WebParam(name = "PersonId", targetNamespace = "") Long id);
}
