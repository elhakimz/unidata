package org.hakeem.unidata.entities.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Menu Definition with ACL
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SystemMenu extends BaseModel implements Serializable, Cloneable{


    @Column
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private ESystemMenuType menuType;

    @Column
    private int level;

    @ManyToOne
    private SystemMenu parentMenu;

    @ManyToOne
    private SystemAcl systemAcl;
}
