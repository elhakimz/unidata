package org.hakeem.unidata.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CommunicationEvent extends BaseModel {

      @Column
      private LocalDate started;

      @Column
      private LocalDate ended;

      @Column
      private String note;

      @ManyToOne
      private PartyRelationship inContextOf;
}
