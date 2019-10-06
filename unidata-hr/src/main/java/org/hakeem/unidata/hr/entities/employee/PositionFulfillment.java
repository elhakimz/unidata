package org.hakeem.unidata.hr.entities.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.base.entities.Party;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class PositionFulfillment extends BaseModel {

    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate thruDate;

    @Column
    private String comment;

    @ManyToOne
    private Position fulfillmentOfPos;

    @ManyToOne
    private Party acceptedBy;
}
