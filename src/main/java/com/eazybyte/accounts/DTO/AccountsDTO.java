package com.eazybyte.accounts.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class AccountsDTO {

    @NotEmpty
    @Pattern(regexp="[0-9]{10}", message = "Account Number must be 10 Digits")
    private Long accountNumber;
    @NotEmpty
    private String accountType;
    @NotEmpty
    private String branchAddress;
}
