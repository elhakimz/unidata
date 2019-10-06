package org.hakeem.unidata.hr.repositories;

import org.hakeem.unidata.hr.entities.employee.BudgetItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BudgetItemRepository extends CrudRepository<BudgetItem, UUID> {

}
