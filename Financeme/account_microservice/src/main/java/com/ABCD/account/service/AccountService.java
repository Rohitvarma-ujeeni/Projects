package com.ABCD.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ABCD.account.entity.Account;
import com.ABCD.account.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account create(Account account) {
        return repository.save(account);
    }

    public Account update(String accountNo, Account updatedAccount) {
        Account account = repository.findById(accountNo).orElseThrow();
        account.setName(updatedAccount.getName());
        account.setEmail(updatedAccount.getEmail());
        account.setPolicy(updatedAccount.getPolicy());
        return repository.save(account);
    }

    public Optional<Account> view(String accountNo) {
        return repository.findById(accountNo);
    }

    public void delete(String accountNo) {
        repository.deleteById(accountNo);
    }
}

