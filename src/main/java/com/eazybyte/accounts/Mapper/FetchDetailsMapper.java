package com.eazybyte.accounts.Mapper;

import com.eazybyte.accounts.DTO.AllDetailsDTO;
import com.eazybyte.accounts.Entity.Accounts;
import com.eazybyte.accounts.Entity.AllDetails;
import com.eazybyte.accounts.Entity.Customer;

public class FetchDetailsMapper {


    public static AllDetailsDTO mapToAllDetailsDTO(Customer customer, Accounts accounts, AllDetailsDTO allDetailsDTO){
       allDetailsDTO.setAccountNumber(accounts.getAccountNumber());
       allDetailsDTO.setName(customer.getName());
       allDetailsDTO.setEmail(customer.getEmail());
       allDetailsDTO.setMobileNumber(customer.getMobileNumber());
       allDetailsDTO.setAccountType(accounts.getAccountType());
       allDetailsDTO.setBranchAddress(accounts.getBranchAddress());
       return allDetailsDTO;
    }


}
