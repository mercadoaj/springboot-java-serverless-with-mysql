package com.api.demo.repository;

import java.util.List;
import java.util.Optional;
import com.api.demo.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrMiddleNameIgnoreCaseContaining(String firstName, String lastName, String middleName);
    List<Person> findAll();
    Optional<Person> findById(Long id);
}