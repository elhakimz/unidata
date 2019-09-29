package org.hakeem.unidata.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
