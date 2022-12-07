package ru.codemark.management.mapper;

import org.mapstruct.Mapper;
import ru.codemark.management.dto.RoleDto;
import ru.codemark.management.dto.request.RequestRole;
import ru.codemark.management.dto.response.ResponseRole;
import ru.codemark.management.entity.Role;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Set<RoleDto> setRequestRoleToSetRoleDto(Set<RequestRole> requestRoles);

    Set<ResponseRole> setRoleDtoToSetResponseRole(Set<RoleDto> roles);

    Set<Role> setRoleDtoToSetRole(Set<RoleDto> roleDto);

    Set<RoleDto> setRoleToSetRoleDto(Set<Role> roles);

}
