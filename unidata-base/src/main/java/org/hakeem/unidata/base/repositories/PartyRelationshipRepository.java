package org.hakeem.unidata.base.repositories;

import org.hakeem.unidata.base.entities.PartyRelationship;
import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartyRelationshipRepository extends UnidataCrudRepository<PartyRelationship, UUID> {

}
