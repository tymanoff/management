package ru.codemark.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.codemark.management.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
