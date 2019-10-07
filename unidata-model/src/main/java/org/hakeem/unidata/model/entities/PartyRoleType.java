package org.hakeem.unidata.model.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Type of roles
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRoleType extends BaseEntity {


    @Column
    private String name;

}
