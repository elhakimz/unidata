package org.hakeem.unidata.repositories;

import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.entities.Party;
import org.hakeem.unidata.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends UnidataCrudRepository<Person, UUID> {

    Person findByParty(Party party);
}
