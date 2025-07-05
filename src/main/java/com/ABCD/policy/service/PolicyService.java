package com.ABCD.policy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ABCD.policy.entity.Policy;
import com.ABCD.policy.repository.PolicyRepository;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository repository;

    public Policy create(Policy policy) {
        return repository.save(policy);
    }

    public Policy update(String policyId, Policy updatedPolicy) {
        Policy policy = repository.findById(policyId).orElseThrow();
        policy.setName(updatedPolicy.getName());
        policy.setEmail(updatedPolicy.getEmail());
        policy.setPolicyType(updatedPolicy.getPolicyType());
        return repository.save(policy);
    }

    public Optional<Policy> view(String policyId) {
        return repository.findById(policyId);
    }

    public void delete(String policyId) {
        repository.deleteById(policyId);
    }
}
