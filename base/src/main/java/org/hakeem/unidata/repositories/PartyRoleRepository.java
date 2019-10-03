package org.hakeem.unidata.repositories;

import org.hakeem.unidata.entities.PartyRole;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PartyRoleRepository extends CrudRepository<PartyRole, UUID> {
}
