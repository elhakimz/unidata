package org.hakeem.unidata.hr.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRelationship extends BaseModel {


    @ManyToOne
    private PartyRole involveFrom;

    @ManyToOne
    private PartyRole  involveTo;

    @ManyToOne
    private PartyRelationshipType relationshipType;

    @Column
    private String description;

    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate toDate;
}
