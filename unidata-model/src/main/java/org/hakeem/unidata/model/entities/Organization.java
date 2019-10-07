package org.hakeem.unidata.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * an organization is a free entity
 * before it is defined as a party with type ORGANiZAtiON
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Organization extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    private Party party;

    @NotBlank(message = "{base.name.notempty}")
    @Column
    private String name;

    @Column
    private String taxIdNumber;


}
