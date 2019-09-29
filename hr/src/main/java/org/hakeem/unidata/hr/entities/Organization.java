package org.hakeem.unidata.hr.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.entities.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Organization extends BaseModel {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    private Party party;

    @Column
    private String taxIdNumber;


}
