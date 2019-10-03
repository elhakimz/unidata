package org.hakeem.unidata.hr.entities.employee;

import lombok.Data;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Entity;

@Data
@Entity
public class PositionType extends BaseModel {

    private String description;

    private String title;

    private Double benefitPct;

}
