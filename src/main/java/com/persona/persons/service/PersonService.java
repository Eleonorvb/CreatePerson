package com.persona.persons.service;

import com.persona.persons.domain.Person;
import com.persona.persons.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private PersonRepository personRepository;

@Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public void save(Person person){
    personRepository.save(person);
    }

    public List<Person> listAll()
    {return personRepository.findAll();
    }

    public Optional<Person> findPerson(long id){
return personRepository.findById(id);
}

@Transactional
public void deletePerson(long id){
    personRepository.deleteById(id);
}
}
