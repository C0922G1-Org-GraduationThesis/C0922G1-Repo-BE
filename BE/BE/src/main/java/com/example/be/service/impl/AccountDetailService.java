package com.example.be.service.impl;

import com.example.be.model.Account;
import com.example.be.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AccountDetailService implements UserDetailsService {

        @Autowired
        IAccountRepository accountRepository;
        @Override
        @Transactional
        public UserDetails loadUserByUsername(String email)  {
            Account account = accountRepository.findAccountByEmail(email);
            if(account==null){
                throw new UsernameNotFoundException("User " + email + " was not found in the database");
            }
            return AccountDetails.build(account);
        }
    }