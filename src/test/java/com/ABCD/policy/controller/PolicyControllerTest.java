package com.ABCD.policy.controller;

import com.ABCD.policy.entity.Policy;
import com.ABCD.policy.service.PolicyService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PolicyController.class)
public class PolicyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PolicyService policyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreatePolicy() throws Exception {
        Policy inputPolicy = new Policy();
        inputPolicy.setPolicyId("P123");
        inputPolicy.setName("Hari");
        inputPolicy.setEmail("hari@example.com");
        inputPolicy.setPolicyType("Life");

        Mockito.when(policyService.create(any(Policy.class))).thenReturn(inputPolicy);

        mockMvc.perform(post("/createPolicy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inputPolicy)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.policyId").value("P123"))
                .andExpect(jsonPath("$.name").value("Hari"))
                .andExpect(jsonPath("$.email").value("hari@example.com"))
                .andExpect(jsonPath("$.policyType").value("Life"));
    }
}
