package com.eazybyte.accounts.Repo;

import com.eazybyte.accounts.Entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts,Long> {
    Accounts findByCustomerId(Long customerId);
}
