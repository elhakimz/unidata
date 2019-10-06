package org.hakeem.unidata.model.repositories;


import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.model.entities.Party;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartyRepository extends UnidataCrudRepository<Party, UUID> {

}
