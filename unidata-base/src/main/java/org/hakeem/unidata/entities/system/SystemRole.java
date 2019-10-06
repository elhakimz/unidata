package org.hakeem.unidata.entities.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Role description with Acl
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SystemRole extends BaseModel implements Serializable, Cloneable{



    @Column
    private String name;

    @Column
    private boolean canRead;

    @Column
    private boolean canEdit;

    @Column
    private boolean canDelete;

    @Column
    private boolean canExecute;

    @ManyToOne
    private SystemAcl systemAcl;
}
