package com.eazybyte.accounts.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@MappedSuperclass  // This Will acts as Superclass for all the entities
@Getter@Setter
@ToString@NoArgsConstructor@AllArgsConstructor
public class BaseEntity {


    @Column(updatable = false)    // This will not update the data while preforming CRUD's Update operation.
    private LocalDateTime createdAt;

    @Column(updatable = false)       // This will not update the data while preforming CRUD's Update operation.
    private String createdBy;

    @Column(insertable = false)         // This will not insert data inside when new data is provided to the DB and provide null value
    private LocalDateTime updatedAt;

    @Column(insertable = false)       // This will not insert data inside when new data is provided to the DB and provide null value
    private String updatedBy;

}
