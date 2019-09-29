package org.hakeem.unidata.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRelationshipType extends BaseModel {

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne
    private PartyRoleType fromRoleType;

    @ManyToOne
    private PartyRoleType toRoleType;

}
