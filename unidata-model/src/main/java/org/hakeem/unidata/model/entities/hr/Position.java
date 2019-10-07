package org.hakeem.unidata.model.entities.hr;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;
import org.hakeem.unidata.model.entities.Party;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Position  extends BaseEntity {

    @ManyToOne
    private PositionType describedBy;

    @ManyToOne
    private Party withinOrg;

    @Column
    private LocalDate estFromDate;

    @Column
    private LocalDate estThruDate;

    @Column
    private Boolean salaryFlag;

    @Column
    private Boolean exemptFlag;

    @Column
    private Boolean fulltimeFlag;

    @Column
    private  Boolean temporaryFlag;

    @Enumerated(EnumType.STRING)
    private EPositionStatusType status;

    @Column
    private LocalDate actFromDate;

    @Column
    private LocalDate actThruDate;

    @Column
    private BudgetItem approvedThru;

}
