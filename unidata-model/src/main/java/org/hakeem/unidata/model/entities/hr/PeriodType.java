package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 *
 * The PERIOD TYPE associated with
 * this record is determined by how the enterprise wants to see this data.
 * for example: daily, weekly, monthly, semester , yearly , quarterly etc
 * @author abil
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class PeriodType extends BaseEntity {

    @NotNull
    @Column(unique = true)
    private String typeId;

    @Column
    private String description;
}
