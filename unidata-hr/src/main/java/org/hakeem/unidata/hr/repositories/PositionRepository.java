package org.hakeem.unidata.hr.repositories;

import org.hakeem.unidata.hr.entities.employee.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PositionRepository extends CrudRepository<Position, UUID> {

}
