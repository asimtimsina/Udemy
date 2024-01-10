package com.eazybyte.accounts.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="costumer")
@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(name="native",strategy = "native")
    private Long customerId;

    private String name;
    private String email;
    private String mobileNumber;


}
