package com.eazybyte.accounts.Entity;

import lombok.Data;

@Data
public class AllDetails {
    private String name;
    private String email;
    private String mobileNumber;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
