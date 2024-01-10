package com.eazybyte.accounts.DTO;

import lombok.Data;

@Data
public class AllDetailsDTO {
    private String name;
    private String email;
    private String mobileNumber;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
