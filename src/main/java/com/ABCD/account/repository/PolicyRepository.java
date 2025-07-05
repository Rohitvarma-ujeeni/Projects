package com.ABCD.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ABCD.policy.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, String> {
}
