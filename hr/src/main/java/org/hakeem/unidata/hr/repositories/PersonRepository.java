package org.hakeem.unidata.hr.repositories;

import org.hakeem.unidata.hr.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
