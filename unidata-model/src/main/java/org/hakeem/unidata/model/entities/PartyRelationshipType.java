package org.hakeem.unidata.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Type of relationship
 * For example Role type Employee and Role type Company defines Relationship
 * called Employment
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRelationshipType extends BaseEntity {

    /**
     * Type name
     */
    @Column
    private String name;

    /**
     * description
     */
    @Column
    private String description;

    /**
     * Role type
     */
    @ManyToOne
    private PartyRoleType fromRoleType;

    /**
     * role type
     */
    @ManyToOne
    private PartyRoleType toRoleType;

}
