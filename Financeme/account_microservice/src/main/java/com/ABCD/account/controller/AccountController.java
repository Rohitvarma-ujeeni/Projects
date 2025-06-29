package com.ABCD.account.controller;

import com.ABCD.account.entity.Account;
import com.ABCD.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(service.create(account));
    }

    @PutMapping("/update/{accountNo}")
    public ResponseEntity<Account> updateAccount(@PathVariable String accountNo, @RequestBody Account account) {
        return ResponseEntity.ok(service.update(accountNo, account));
    }

    @GetMapping("/view/{accountNo}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNo) {
        return service.view(accountNo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{accountNo}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountNo) {
        service.delete(accountNo);
        return ResponseEntity.ok("Deleted successfully");
    }
}
