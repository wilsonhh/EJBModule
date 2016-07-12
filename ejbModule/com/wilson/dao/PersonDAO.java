package com.wilson.dao;

import java.util.List;

import com.wilson.model.Person;
 
public interface PersonDAO {
 
    public Person addPerson(Person p);
    public Person getPerson(int id);
    public List<Person> listPersons();
    public void removePerson(Person p);
    public List<Person> listPersons(String name);
}