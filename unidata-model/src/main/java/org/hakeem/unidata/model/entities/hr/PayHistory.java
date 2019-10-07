package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Actual salary or pay, represented by PAY HISTORY, is related to a person, not
 * POSITION or POSITION TYPE. In fact, it is really related to the EMPLOYMENT
 * (which is a subtype of PARTY RELATIONSHIP) that exists between the
 * employer and employee.
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PayHistory extends BaseEntity {

    @NotNull
    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate thruDate;

    @Column
    private BigDecimal amount = new BigDecimal(0);

    @Column
    private String comment;

    @ManyToOne
    private SalaryStep associatedWith;

    @ManyToOne
    private PeriodType forPeriodType;
}
