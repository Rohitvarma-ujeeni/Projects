package com.ABCD.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ABCD.account.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}
