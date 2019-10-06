package org.hakeem.unidata.repositories;

import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.entities.PartyRelationship;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartyRelationshipRepository extends UnidataCrudRepository<PartyRelationship, UUID> {

}
