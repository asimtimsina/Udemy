package com.eazybyte.accounts.DTO;

import lombok.*;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class AccountsDTO {

    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
