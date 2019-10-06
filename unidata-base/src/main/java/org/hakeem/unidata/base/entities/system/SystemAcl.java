package org.hakeem.unidata.base.entities.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SystemAcl extends BaseModel implements Serializable, Cloneable{



    @Column
    private String name;

    @Column
    private String description;

    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate toDate;

}
