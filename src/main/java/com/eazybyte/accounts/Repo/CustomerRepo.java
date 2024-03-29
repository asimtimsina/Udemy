package com.eazybyte.accounts.Repo;

import com.eazybyte.accounts.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {


    Optional<Customer> findBymobileNumber(String mobileNumber);
    Optional<Customer> findByCustomerId(Long customerId);
}
