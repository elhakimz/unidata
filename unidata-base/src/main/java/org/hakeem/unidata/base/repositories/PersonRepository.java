package org.hakeem.unidata.base.repositories;

import org.hakeem.unidata.base.entities.Party;
import org.hakeem.unidata.base.entities.Person;
import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends UnidataCrudRepository<Person, UUID> {

    Person findByParty(Party party);
}
