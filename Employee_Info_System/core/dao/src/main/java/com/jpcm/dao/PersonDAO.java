package com.jpcm.dao;
import com.jpcm.model.*;
import java.util.List;

public interface PersonDAO{
    public void savePerson (Person person);
    public void updatePerson (Person person);
    public void deletePerson (Long id);
    public void deleteContact (Long id, Long deleteContact);
    public List<Person> fetchPersons(String action);
    public List<Person> searchPersonId (Long id);
    public List<Person> searchPerson (String searchType, String searchValue);
}

