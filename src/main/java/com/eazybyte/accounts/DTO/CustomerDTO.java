package com.eazybyte.accounts.DTO;

import com.eazybyte.accounts.Entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;


@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class CustomerDTO extends BaseEntity {


    @NotEmpty(message = "Name cannot be Null or Empty")
    private String name;
    @NotEmpty(message="Email cannot be Null or Empty")
    @Email(message="Invalid Email id format")
    private String email;
    @NotEmpty
    @Pattern(regexp="[0-9]{10}", message = "Mobile Number must be 10 Digits")
    private String mobileNumber;


}
