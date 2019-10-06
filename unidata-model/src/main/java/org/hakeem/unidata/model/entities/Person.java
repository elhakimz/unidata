package org.hakeem.unidata.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * A Person is a free entity, before it is defined as a party with role.
 * A person can only have one party
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Person extends BaseModel {


    @NotNull
    @NotBlank
    @Column
    private String firstName;

    @NotNull
    @NotBlank
    @Column
    private String lastName;


    @Column
    private String nickName;

    @Column
    private LocalDate birthDate;

    @Column
    private String birthPlace;

    @Column
    private String idNumber;

    @ManyToOne
    private Party party;

}
