package ru.codemark.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.codemark.management.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
