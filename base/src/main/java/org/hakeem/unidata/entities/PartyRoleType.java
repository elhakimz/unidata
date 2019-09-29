package org.hakeem.unidata.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

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
