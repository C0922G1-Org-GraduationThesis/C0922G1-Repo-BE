package com.example.be.service;

import com.example.be.model.Account;

public interface IAccountService {
    Account findAccountByEmail(String email);
}
