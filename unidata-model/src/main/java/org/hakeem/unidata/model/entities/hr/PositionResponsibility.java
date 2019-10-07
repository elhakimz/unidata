package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class PositionResponsibility extends BaseEntity {

    @NotNull
    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate thruDate;

    @Column
    private String comment;

    @ManyToOne
    private Position associatedWith;

    @Enumerated(EnumType.ORDINAL)
    private EResponsibilityType definedBy;
}
