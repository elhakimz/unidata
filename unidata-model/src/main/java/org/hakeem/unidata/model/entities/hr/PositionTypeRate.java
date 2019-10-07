package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author  abil
 *
 * The POSITION TYPE RATE and RATE TYPE entities  to provide the costs and standard rates for various types of
 * positions in order to capture appropriate cost estimates for work efforts. This
 * section will expand the use of this entity to incorporate other types of position
 * rates for tracking standard pay rates and ranges.
 * The POSITION RATE TYPE entity may be used to record the allowable or
 * acceptable salary and salary ranges for a particular position type. This information
 * could be used by managers during the hiring process when negotiating
 * salary. A from date and thru date are included so that a history of these standards
 * can also be kept.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PositionTypeRate extends BaseEntity {

    @Column
    @NotNull
    private LocalDate fromDate;

    @Column
    private LocalDate thruDate;

    @Column
    private BigDecimal rate;

    @Enumerated(EnumType.STRING)
    private ERateType type;

    @ManyToOne
    private SalaryStep associatedWith;

    @ManyToOne
    private PositionType forPositionType;

    @ManyToOne
    private PeriodType forPeriodType;

}
