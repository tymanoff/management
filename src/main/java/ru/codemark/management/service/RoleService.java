package ru.codemark.management.service;

import ru.codemark.management.dto.RoleDto;

import java.util.Set;

public interface RoleService {
    Set<RoleDto> createRole(Set<RoleDto> roleDto);
}
