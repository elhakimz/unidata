package org.hakeem.unidata.model.repositories.hr;

import org.hakeem.unidata.model.entities.hr.BudgetItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetItemRepository extends CrudRepository<BudgetItem, UUID> {

}
