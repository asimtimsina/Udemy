package com.eazybyte.accounts.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AllDetailsDTO {

    @NotEmpty(message = "Name cannot be Null or Empty")
    private String name;


    @NotEmpty(message="Email cannot be Null or Empty")
    @Email(message="Invalid Email id format")
    private String email;


    @NotEmpty
    @Pattern(regexp="[0-9]{10}", message = "Mobile Number must be 10 Digits")
    private String mobileNumber;


    @NotEmpty
    @Pattern(regexp="[0-9]{10}", message = "Account Number must be 10 Digits")
    private Long accountNumber;


    @NotEmpty
    private String accountType;


    @NotEmpty
    private String branchAddress;
}
