package org.hakeem.unidata.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Type of roles
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRoleType extends BaseModel {


    @Column
    private String name;

}
