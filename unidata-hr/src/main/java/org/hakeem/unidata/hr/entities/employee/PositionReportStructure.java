package org.hakeem.unidata.hr.entities.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PositionReportStructure  extends BaseModel {

    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate thruDate;

    @Column
    private String comments;

    @Column
    private Boolean primaryFlag;

    @ManyToOne
    private Position reportTo;

    @ManyToOne
    private Position managedBy;
}
