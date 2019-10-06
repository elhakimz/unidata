package org.hakeem.unidata.hr.entities.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;
import org.hakeem.unidata.entities.Party;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Position  extends BaseModel {

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

}
