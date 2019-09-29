package org.hakeem.unidata.hr.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRoleType extends BaseModel {


    @Column
    private String name;

}
