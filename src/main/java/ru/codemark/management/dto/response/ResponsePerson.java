package ru.codemark.management.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ResponsePerson {
    private Long id;
    private String login;
    private String name;
    private Set<ResponseRole> responseRoles;
}
