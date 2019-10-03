package org.hakeem.unidata.repositories;

import org.hakeem.unidata.entities.Party;
import org.hakeem.unidata.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
    List<Person> findAll();
    Person findByParty(Party party);
}
