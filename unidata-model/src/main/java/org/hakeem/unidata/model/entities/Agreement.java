package org.hakeem.unidata.model.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * An Agreement is defined by Parties which attached on a party relationship
 * Like contracts, agreements, etc
 * @author abiel
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Agreement extends BaseEntity {

    /**
     * agreement number
     */
    @NotNull @NotEmpty
    @Column
    private String agreementNo;

    /**
     * description of the agreement
     */
    @Column
    private String description;

}
