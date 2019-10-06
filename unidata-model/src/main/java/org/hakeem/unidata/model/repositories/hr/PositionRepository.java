package org.hakeem.unidata.model.repositories.hr;

import org.hakeem.unidata.model.entities.hr.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PositionRepository extends CrudRepository<Position, UUID> {

}
