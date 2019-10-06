package org.hakeem.unidata.model.entities.system;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * System user with ACL
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SystemUser extends BaseModel implements Serializable, Cloneable{


    @Column
    private String userName;

    @Column
    private String password;

    @ManyToOne
    private SystemAcl systemAcl;



}
