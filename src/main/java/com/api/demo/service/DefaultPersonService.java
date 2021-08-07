package com.api.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demo.exception.PersonNotFoundException;
import com.api.demo.repository.PersonRepository;
import com.api.demo.entity.Person;


@Service
public class DefaultPersonService implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public DefaultPersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public Person findById(Long id){
        Optional<Person> person = personRepository.findById(id);

        if (!person.isPresent()) 
            throw new PersonNotFoundException(id); 
        
        return person.get();
    }

    @Override
    public Person save(Person person){
       return personRepository.save(person);
    }

    @Override
    public List<Person> findAllPersons(){
        return  personRepository.findAll();
    }

    @Override
    public List<Person> findByName(String name){
        return personRepository.findByFirstNameIgnoreCaseContainingOrLastNameIgnoreCaseContainingOrMiddleNameIgnoreCaseContaining(name,name,name);
    } 

    @Override
    public void deleteById(Long id){
        Person person = findById(id);
        personRepository.delete(person);
    }
}