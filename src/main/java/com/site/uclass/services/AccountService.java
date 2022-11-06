package com.site.uclass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.site.uclass.entities.Account;
import com.site.uclass.repository.AccountRepository;

public class AccountService implements UserDetailsService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("User doesn't exist")
        );

        return account;
    }
}
