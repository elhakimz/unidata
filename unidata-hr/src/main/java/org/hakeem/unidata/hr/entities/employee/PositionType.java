package org.hakeem.unidata.hr.entities.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PositionType extends BaseModel {

    private String description;

    private String title;

    private Double benefitPct;

}
