package org.hakeem.unidata.core.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This is the base model of all data models in UniData
 */
@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel implements Serializable, Cloneable {

    protected static final String NOT_DELETED = "deleted_on > CURRENT_TIMESTAMP OR deleted_on IS NULL";

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    protected LocalDateTime createDate ;

    @Column
    protected  String createBy ="SYSTEM";

    @Column
    protected LocalDateTime changeDate;

    @Column
    protected   String changeBy="SYSTEM";

    @Column
    protected LocalDateTime deletedOn;


    @Version
    protected Long version;


    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
        this.changeDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.changeDate = LocalDateTime.now();
    }


}
