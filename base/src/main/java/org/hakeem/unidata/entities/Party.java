package org.hakeem.unidata.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * class Party
 * Party is a business/event participant in the business ecosystem
 * the Party should be a Person or an Organization
 * A party can have multiple roles
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Entity
public class Party extends BaseModel {

    /**
     * Name of the party
     */
    @NotNull
    @NotBlank(message="{base.name.notempty}")
    @Column
    private String name;

    /**
     * Type of the party , PERSON or ORGANiZATION
     */
    @Enumerated(EnumType.STRING)
    private EPartyType type;
}
