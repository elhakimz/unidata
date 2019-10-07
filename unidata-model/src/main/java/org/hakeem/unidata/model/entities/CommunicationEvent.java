package org.hakeem.unidata.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hakeem.unidata.core.commons.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CommunicationEvent extends BaseEntity {

      @Column
      private LocalDate started;

      @Column
      private LocalDate ended;

      @Column
      private String note;

      @ManyToOne
      private PartyRelationship inContextOf;
}
