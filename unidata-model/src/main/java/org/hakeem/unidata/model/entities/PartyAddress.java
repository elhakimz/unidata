package org.hakeem.unidata.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Class Party Address
 * store information about an address of a party
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class PartyAddress extends BaseEntity {

    @Column
    private String street;

    @Column
    private  String area;

    @Column
    private String city;

    @Column
    private String state;

    /**
     * is it current/prime address ?
     */
    @Column
    private Boolean prime = false;

    /**
     * owner of the address
     */
    @ManyToOne
    private Party party;


}
