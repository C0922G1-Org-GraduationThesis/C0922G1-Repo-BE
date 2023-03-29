package com.example.be.service.impl;

import com.example.be.model.Account;
import com.example.be.repository.IAccountRepository;
import com.example.be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public Account findAccountByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }
}
