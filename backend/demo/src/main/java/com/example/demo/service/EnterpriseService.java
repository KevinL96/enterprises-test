// src/main/java/com/example/demo/service/EnterpriseService.java
package com.example.demo.service;

import com.example.demo.model.Enterprise;
import com.example.demo.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }

    public Enterprise getEnterpriseById(Long id) {
        return enterpriseRepository.findById(id).orElse(null);
    }

    public Enterprise createEnterprise(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise updateEnterprise(Long id, Enterprise enterpriseDetails) {
        Enterprise enterprise = enterpriseRepository.findById(id).orElse(null);
        if (enterprise != null) {
            enterprise.setName(enterpriseDetails.getName());
            // Update other fields as needed
            return enterpriseRepository.save(enterprise);
        }
        return null;
    }

    public void deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(id);
    }
}
