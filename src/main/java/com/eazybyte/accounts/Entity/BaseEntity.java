package com.eazybyte.accounts.Entity;

import com.eazybyte.accounts.Audit.AuditAwareImpl;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@MappedSuperclass  // This Will acts as Superclass for all the entities
@Getter@Setter
@ToString@NoArgsConstructor@AllArgsConstructor
@EntityListeners(AuditAwareImpl.class)
public class  BaseEntity {
    @Hidden
    @CreatedDate
    @Column(updatable = false)    // This will not update the data while preforming CRUD's Update operation.
    private LocalDateTime createdAt;

    @Hidden
    @CreatedBy
    @Column(updatable = false)       // This will not update the data while preforming CRUD's Update operation.
    private String createdBy;

    @Hidden
    @LastModifiedDate
    @Column(insertable = false)         // This will not insert data inside when new data is provided to the DB and provide null value
    private LocalDateTime updatedAt;

    @Hidden
    @LastModifiedBy
    @Column(insertable = false)       // This will not insert data inside when new data is provided to the DB and provide null value
    private String updatedBy;

}
