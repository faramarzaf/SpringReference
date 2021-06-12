package com.example.BlackMan1.dao;

import com.example.BlackMan1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person(UUID.randomUUID(),"FROM postgres db"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonByID(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonByID(UUID id, Person person) {
        return 0;
    }
}
