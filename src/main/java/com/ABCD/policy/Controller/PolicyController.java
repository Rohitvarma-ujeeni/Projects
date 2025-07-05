package com.ABCD.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ABCD.policy.entity.Policy;
import com.ABCD.policy.service.PolicyService;

@RestController
public class PolicyController {

    @Autowired
    private PolicyService service;

    @PostMapping("/createPolicy")
    public ResponseEntity<?> createPolicy(@RequestBody Policy policy) {
        return ResponseEntity.ok(service.create(policy));
    }

    @PutMapping("/updatePolicy/{policyId}")
    public ResponseEntity<?> updatePolicy(@PathVariable String policyId, @RequestBody Policy policy) {
        return ResponseEntity.ok(service.update(policyId, policy));
    }

    @GetMapping("/viewPolicy/{policyId}")
    public ResponseEntity<?> viewPolicy(@PathVariable String policyId) {
        return service.view(policyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePolicy/{policyId}")
    public ResponseEntity<?> deletePolicy(@PathVariable String policyId) {
        service.delete(policyId);
        return ResponseEntity.ok("Deleted successfully");
    }
}
