package org.hakeem.unidata.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class PartyAddress extends BaseModel {

    @Column
    private String street;

    @Column
    private  String area;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private Boolean prime = false;

    @ManyToOne
    private Party party;


}
