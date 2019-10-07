package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;


/**
 * @author abil
 * Salary Step m:1 PayGrade
 * Additional information stored in this entity could also include a PAY GRADE
 * and SALARY STEP for use in enterprises that have a predefined, highly structured
 * pay system (such as the federal government). This is done by reference to
 * a structured pay schedule. These types of schedules normally have two levels:
 * a grade and a step. The SALARY STEP entity includes an amount attribute and
 * is generally described in the context of a PAY GRADE.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class SalaryStep extends BaseEntity {


    @NotEmpty
    @Column
    private String seqId;  //sequence id

    @Column
    private BigDecimal amount = new BigDecimal(0);  //amount of this step

    @ManyToOne
    private PayGrade partOf;     //part of grade

}
