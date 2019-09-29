package org.hakeem.unidata.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * This is the base model of all data models in UniData
 */
@MappedSuperclass
@Data
public class BaseModel implements Serializable, Cloneable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    protected LocalDate createDate = LocalDate.now();

    @Column
    protected  String createBy ="SYSTEM";

    @Column
    protected LocalDate changeDate;

    @Column
    protected   String changeBy="SYSTEM";

    @Column
    protected  Boolean deleted = false;
}
