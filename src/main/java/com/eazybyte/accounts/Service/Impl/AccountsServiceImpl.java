package com.eazybyte.accounts.Service.Impl;
import com.eazybyte.accounts.Constants.AccountConstants;
import com.eazybyte.accounts.DTO.CustomerDTO;
import com.eazybyte.accounts.DTO.AllDetailsDTO;
import com.eazybyte.accounts.Entity.Accounts;
import com.eazybyte.accounts.Entity.Customer;
import com.eazybyte.accounts.Exception.CustomerAlreadyExistException;
import com.eazybyte.accounts.Exception.ResourceNotFoundException;
import com.eazybyte.accounts.Mapper.CustomerMapper;
import com.eazybyte.accounts.Mapper.FetchDetailsMapper;
import com.eazybyte.accounts.Repo.AccountsRepo;
import com.eazybyte.accounts.Repo.CustomerRepo;
import com.eazybyte.accounts.Service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private AccountsRepo accountsRepo;
    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public void createAccount(CustomerDTO customerDTO) {

        Optional<Customer> cus = customerRepo.findBymobileNumber(customerDTO.getMobileNumber());
        if(cus.isPresent()) throw  new CustomerAlreadyExistException("Customer already registered with given Mobile Number: "+customerDTO.getMobileNumber());


        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        customer.setCreatedBy("Nischal Timsina");
        customer.setCreatedAt(LocalDateTime.now() );
        Customer savedCustomer = customerRepo.save(customer);
        accountsRepo.save(createNewAccount(savedCustomer));

    }

    @Override
    public AllDetailsDTO fetchByMobileNumber(String mobileNumber) {
        Customer cus = customerRepo.findBymobileNumber(mobileNumber)
                .orElseThrow( () -> new ResourceNotFoundException("Customer","Mobile Number", mobileNumber));
        Accounts acc = accountsRepo.findByCustomerId(cus.getCustomerId());
        AllDetailsDTO allDetailsDTO = FetchDetailsMapper.mapToAllDetailsDTO(cus,acc,new AllDetailsDTO());
        return allDetailsDTO;
    }

//    @Override
//    public boolean updateAccount(FetchAllDTO fetchAllDTO) {
//        return false;
//    }


    private Accounts createNewAccount(Customer customer){
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNum = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNum);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Nischal Timsina");
        return newAccount;
    }


}
