package org.hakeem.unidata.base.repositories;

import org.hakeem.unidata.base.entities.Party;
import org.hakeem.unidata.base.entities.PartyAddress;
import org.hakeem.unidata.core.commons.UnidataCrudRepository;

import java.util.UUID;

public interface PartyAddressRepository  extends UnidataCrudRepository<PartyAddress, UUID> {

    PartyAddress findByParty(Party party);
}
