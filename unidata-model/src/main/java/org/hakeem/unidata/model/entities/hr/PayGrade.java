package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * author abil
 *
 */
@Entity
@Data
public class PayGrade extends BaseEntity {


    @Column
    private String gradeId;

    @Column
    private String name;

    @Column
    private String comment;

}
