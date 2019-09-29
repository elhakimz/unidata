package org.hakeem.unidata.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * class Party Relationship
 * defines relationship between parties with defined role
 * the relationship should be described  , with the valid start and end date of relationship
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRelationship extends BaseModel {


    /**
     * involved party with business role
     */
    @ManyToOne
    private PartyRole involveFrom;

    /**
     * involved party with business role
     */
    @ManyToOne
    private PartyRole  involveTo;

    /**
     * type of relationship
     */
    @ManyToOne
    private PartyRelationshipType relationshipType;

    /**
     * description of the relationship
     */
    @Column
    private String description;

    /**
     * valid from date
     */
    @Column
    private LocalDate fromDate;

    /**
     * valid until date
     */
    @Column
    private LocalDate toDate;
}
