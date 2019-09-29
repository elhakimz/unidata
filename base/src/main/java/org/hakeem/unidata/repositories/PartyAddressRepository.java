package org.hakeem.unidata.repositories;

import org.hakeem.unidata.entities.Party;
import org.hakeem.unidata.entities.PartyAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PartyAddressRepository  extends CrudRepository<PartyAddress, UUID> {

    PartyAddress findByParty(Party party);
}
