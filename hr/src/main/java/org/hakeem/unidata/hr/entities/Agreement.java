package org.hakeem.unidata.hr.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Agreement extends BaseModel {

    @NotNull @NotEmpty
    @Column
    private String agreementNo;

    @Column
    private String description;

}
