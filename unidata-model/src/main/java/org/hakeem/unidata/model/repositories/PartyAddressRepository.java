package org.hakeem.unidata.model.repositories;

import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.model.entities.Party;
import org.hakeem.unidata.model.entities.PartyAddress;

import java.util.UUID;

public interface PartyAddressRepository  extends UnidataCrudRepository<PartyAddress, UUID> {

    PartyAddress findByParty(Party party);
}
