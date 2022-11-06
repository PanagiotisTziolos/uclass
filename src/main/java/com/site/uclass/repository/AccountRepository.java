package com.site.uclass.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.site.uclass.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    
    public Optional<Account> findByUsername(String username);
}
