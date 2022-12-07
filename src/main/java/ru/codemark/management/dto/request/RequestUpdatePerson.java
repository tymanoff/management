package ru.codemark.management.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class RequestUpdatePerson {
    private Long id;
    private String login;
    private String name;
    private String password;
    private Set<RequestRole> roles;
}
