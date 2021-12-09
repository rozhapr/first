package org.statistics.service;

import org.statistics.entity.Person;
import org.statistics.repository.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private Crud<Person, Long> personCrud;

    @Transactional
    public void save(Person person) {
        personCrud.save(person);
    }

    @Transactional
    public void update(Person person) {
        personCrud.update(person);
    }

    @Transactional
    public void remove(Person person) {
        personCrud.delete(person);
    }


    public Person findOne(Person person) {
        return personCrud.selectOne(Person.class, person.getPersonId());
    }

    public List<Person> findAll() {
        return personCrud.selectAll(Person.class);
    }
}
