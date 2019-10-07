package org.hakeem.unidata.model.entities.hr;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


/**
 * Position Reporting Structure
 * which links POSITION back to itself. The attributes from date and thru
 * date are provided to allow for tracking organizational changes through time,
 * The primary flag attribute is included to help model
 * flexible, matrix-type structures. In these cases, certain positions may report to
 * more than one position at the same time. This indicator allows the enterprise to
 * indicate which reporting relationship is the overriding one
 *
 * @author abil
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class PositionReportingStructure extends BaseEntity {


    @NotNull
    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate thruDate;

    @Column
    private String comment;

    @Column
    private boolean primaryFlag;

    @ManyToOne
    private Position reportTo;

    @Column
    private Position managedBy;

}
