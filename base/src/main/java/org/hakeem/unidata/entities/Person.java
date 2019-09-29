package org.hakeem.unidata.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Person extends BaseModel {


    @NotNull @NotEmpty
    @Column
    private String firstName;

    @NotNull @NotEmpty
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
