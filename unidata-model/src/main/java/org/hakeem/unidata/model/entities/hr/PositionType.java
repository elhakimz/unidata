package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PositionType extends BaseEntity {

    @NotEmpty
    @Column
    private String description;

    @Column
    private Double benefitPct;



}
