package com.technical.service;

import com.technical.ApplicationUserDetails;
import com.technical.entity.Account;
import com.technical.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findById(username)
                .orElseThrow( () -> new UsernameNotFoundException("Username " + username + "not exist!") );

        return new ApplicationUserDetails(account);
    }

}
