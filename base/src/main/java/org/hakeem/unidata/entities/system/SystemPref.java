package org.hakeem.unidata.entities.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.entities.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SystemPref extends BaseModel implements Serializable, Cloneable {



    @Column
    private String groupName;

    @Column
    private String name;

    @Column
    private String value;



}
