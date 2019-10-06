package org.hakeem.unidata.hr.entities.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@ToString(doNotUseGetters = true)
@Data
@Entity
/**
 * Budget Item
 *
 */
public class BudgetItem extends BaseModel {

    @NotEmpty
    @Column
    private String sequenceId;

    @Column
    private BigDecimal amount = new BigDecimal(0);

    @NotNull
    @NotEmpty
    @Column
    private String purpose;

    @NotNull
    @NotEmpty
    @Column
    private String justification;

}
