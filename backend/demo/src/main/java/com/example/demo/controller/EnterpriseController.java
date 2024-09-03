// src/main/java/com/example/demo/controller/EnterpriseController.java
package com.example.demo.controller;

import com.example.demo.model.Enterprise;
import com.example.demo.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprises")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public List<Enterprise> getAllEnterprises() {
        return enterpriseService.getAllEnterprises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEnterpriseById(@PathVariable Long id) {
        Enterprise enterprise = enterpriseService.getEnterpriseById(id);
        return enterprise != null ? ResponseEntity.ok(enterprise) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise) {
        return enterpriseService.createEnterprise(enterprise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enterprise> updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterpriseDetails) {
        Enterprise updatedEnterprise = enterpriseService.updateEnterprise(id, enterpriseDetails);
        return updatedEnterprise != null ? ResponseEntity.ok(updatedEnterprise) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnterprise(@PathVariable Long id) {
        enterpriseService.deleteEnterprise(id);
        return ResponseEntity.noContent().build();
    }
}
