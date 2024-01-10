package com.eazybyte.accounts.Mapper;

import com.eazybyte.accounts.DTO.AllDetailsDTO;
import com.eazybyte.accounts.Entity.Accounts;
import com.eazybyte.accounts.Entity.AllDetails;
import com.eazybyte.accounts.Entity.Customer;

public class FetchDetailsMapper {

   public AllDetails mapToAllDetails(AllDetails allDetails, AllDetailsDTO allDetailsDTO){
       allDetails.setName(allDetailsDTO.getName());
       allDetails.setEmail(allDetailsDTO.getEmail());
       allDetails.setMobileNumber(allDetailsDTO.getMobileNumber());
       allDetails.setAccountNumber(allDetailsDTO.getAccountNumber());
       allDetails.setAccountType(allDetailsDTO.getAccountType());
       allDetails.setBranchAddress(allDetailsDTO.getBranchAddress());
       return allDetails;
    }

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
