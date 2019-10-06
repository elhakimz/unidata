package org.hakeem.unidata.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * class Party Role
 * Before a party involved in a business by relationship
 * a role must be defined like Customer, Contact, Employee or Partner
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PartyRole extends BaseModel {


    @ManyToOne
    private Party party;

    @ManyToOne
    private PartyRoleType roleType;

    @NotNull @NotEmpty
    @Column
    private String name;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;
}
