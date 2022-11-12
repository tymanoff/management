package ru.codemark.management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class PersonDto {
    private Long id;
    private String login;
    private String name;
    private String password;
    private Set<RoleDto> roles;
}
