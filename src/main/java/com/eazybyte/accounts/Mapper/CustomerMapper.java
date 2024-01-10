package com.eazybyte.accounts.Mapper;

import com.eazybyte.accounts.DTO.AccountsDTO;
import com.eazybyte.accounts.DTO.CustomerDTO;
import com.eazybyte.accounts.Entity.Accounts;
import com.eazybyte.accounts.Entity.Customer;

public class CustomerMapper {

    public static CustomerDTO mapToCustomerDTO(Customer customer, CustomerDTO customerDTO){
        customerDTO.setName(customer.getName());
        customerDTO.setMobileNumber(customer.getMobileNumber());
        customerDTO.setEmail(customerDTO.getEmail());
        return customerDTO;
    }

    public static Customer mapToCustomer(CustomerDTO customerDTO, Customer customer){
        customer.setCustomerId(customer.getCustomerId());
        customer.setEmail(customerDTO.getEmail());
        customer.setMobileNumber(customerDTO.getMobileNumber());
        customer.setName(customerDTO.getName());
        return customer;
    }

}
