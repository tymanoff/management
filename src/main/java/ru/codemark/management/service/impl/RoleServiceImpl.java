package ru.codemark.management.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.codemark.management.dto.RoleDto;
import ru.codemark.management.entity.Role;
import ru.codemark.management.mapper.RoleMapper;
import ru.codemark.management.repository.RoleRepository;
import ru.codemark.management.service.RoleService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public Set<RoleDto> createRole(Set<RoleDto> roleDto) {
        Set<Role> roles = roleMapper.setRoleDtoToSetRole(roleDto);
        Set<Role> saveRoles = roles.stream()
                .map(roleRepository::save)
                .collect(Collectors.toSet());

        return roleMapper.setRoleToSetRoleDto(saveRoles);
    }
}
