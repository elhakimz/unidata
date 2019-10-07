package org.hakeem.unidata.model.repositories.hr;

import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.model.entities.hr.PositionResponsibility;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PositionResponsibilityRepository extends UnidataCrudRepository<PositionResponsibility, UUID> {
}
