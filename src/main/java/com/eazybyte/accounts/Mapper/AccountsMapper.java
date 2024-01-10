package com.eazybyte.accounts.Mapper;

import com.eazybyte.accounts.DTO.AccountsDTO;
import com.eazybyte.accounts.Entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO){
        accountsDTO.setAccountNumber(accounts.getAccountNumber());
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setBranchAddress(accounts.getBranchAddress());
        return accountsDTO;
    }

    public static Accounts mapToAccounts(Accounts accounts, AccountsDTO accountsDTO){
        accounts.setAccountNumber(accounts.getAccountNumber());
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setBranchAddress(accounts.getBranchAddress());
        return accounts;
    }

}
