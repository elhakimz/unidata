package org.hakeem.unidata.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Entity
public class Party extends BaseModel {

    @NotNull
    @NotEmpty
    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private EPartyType type;
}
