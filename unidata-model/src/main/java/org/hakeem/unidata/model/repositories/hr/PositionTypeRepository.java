package org.hakeem.unidata.model.repositories.hr;

import org.hakeem.unidata.core.commons.UnidataCrudRepository;
import org.hakeem.unidata.model.entities.hr.PositionType;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PositionTypeRepository extends UnidataCrudRepository<PositionType, UUID> {
}
