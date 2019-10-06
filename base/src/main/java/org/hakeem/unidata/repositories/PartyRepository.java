package org.hakeem.unidata.repositories;

import org.hakeem.unidata.entities.Party;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartyRepository extends UnidataCrudRepository<Party, UUID> {

}
