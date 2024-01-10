package com.eazybyte.accounts.Service;

import com.eazybyte.accounts.DTO.AllDetailsDTO;
import com.eazybyte.accounts.DTO.CustomerDTO;

public interface AccountsService {

    void createAccount(CustomerDTO customerDTO);


    AllDetailsDTO fetchByMobileNumber(String mobileNumber);


    boolean updateAccount(AllDetailsDTO allDetailsDTO);

    boolean DeleteByAccountNumber(Long accountNumber, String mobileNumber);
}
