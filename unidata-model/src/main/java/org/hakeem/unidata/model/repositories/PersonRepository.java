package org.hakeem.unidata.model.repositories;


import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.model.entities.Party;
import org.hakeem.unidata.model.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends UnidataCrudRepository<Person, UUID> {

    Person findByParty(Party party);
}
