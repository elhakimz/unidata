package org.hakeem.unidata.model.repositories;


import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.model.entities.Organization;
import org.hakeem.unidata.model.entities.Party;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepository extends UnidataCrudRepository<Organization, UUID> {

    Organization findByParty(Party party);
}
