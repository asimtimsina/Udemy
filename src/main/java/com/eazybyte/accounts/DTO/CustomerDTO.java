package com.eazybyte.accounts.DTO;

import com.eazybyte.accounts.Entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class CustomerDTO extends BaseEntity {



    private String name;
    private String email;
    private String mobileNumber;


}
