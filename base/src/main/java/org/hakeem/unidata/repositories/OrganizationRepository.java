package org.hakeem.unidata.repositories;

import org.hakeem.unidata.entities.Organization;
import org.hakeem.unidata.entities.Party;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepository extends UnidataCrudRepository<Organization, UUID> {

    Organization findByParty(Party party);
}
