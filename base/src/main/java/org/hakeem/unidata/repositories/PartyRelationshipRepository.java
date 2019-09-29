package org.hakeem.unidata.repositories;

import org.hakeem.unidata.entities.PartyRelationship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartyRelationshipRepository extends CrudRepository<PartyRelationship, UUID> {

}
