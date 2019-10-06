package org.hakeem.unidata.base.repositories;

import org.hakeem.unidata.base.entities.Organization;
import org.hakeem.unidata.base.entities.Party;
import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationRepository extends UnidataCrudRepository<Organization, UUID> {

    Organization findByParty(Party party);
}
