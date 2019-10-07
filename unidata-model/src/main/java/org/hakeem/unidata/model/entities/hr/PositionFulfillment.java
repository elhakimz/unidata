package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;
import org.hakeem.unidata.model.entities.Party;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class PositionFulfillment extends BaseEntity {

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
