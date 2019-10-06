package org.hakeem.unidata.repositories;

import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.entities.Party;
import org.hakeem.unidata.entities.PartyAddress;

import java.util.UUID;

public interface PartyAddressRepository  extends UnidataCrudRepository<PartyAddress, UUID> {

    PartyAddress findByParty(Party party);
}
