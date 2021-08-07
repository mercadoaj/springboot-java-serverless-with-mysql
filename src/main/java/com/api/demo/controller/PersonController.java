package com.api.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.ModelMapper;
import com.api.demo.entity.Person;
import com.api.demo.dto.PersonDTO;
import com.api.demo.service.PersonService;


@RestController
@EnableWebMvc
@RequestMapping(value = "/person",
  produces = MediaType.APPLICATION_JSON_VALUE) 
public class PersonController implements ApiOperations{

    @Autowired
	private PersonService personService;

    @Autowired
    ModelMapper modelMapper; 

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<Person> findById( @PathVariable("id") Long id) {
        Person person = personService.findById(id);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @Override 
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<PersonDTO> Persons = personService.findAllPersons()
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
        return new ResponseEntity<>(Persons,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> save(@RequestBody Person person) {
        Person p = personService.save(person);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> findByName(@PathVariable("name") String name) {
        List<PersonDTO> Persons = personService.findByName(name)
        .stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
        return new ResponseEntity<>(Persons,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> remove(@PathVariable("id") Long id) {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> changeName(@PathVariable("id") Long id, @RequestBody Person person) {
        Person p = personService.findById(id);
        p.setFirstName(person.getFirstName());
        p.setMiddleName(person.getMiddleName());
        p.setLastName(person.getLastName());
        personService.save(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    private PersonDTO convertToDTO(Person Person) { 
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.LOOSE);
        PersonDTO PersonDTO = modelMapper
            .map(Person, PersonDTO.class);  
        return PersonDTO;
    }
}