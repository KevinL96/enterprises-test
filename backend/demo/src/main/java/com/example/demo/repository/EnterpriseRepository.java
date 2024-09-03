// src/main/java/com/example/demo/repository/EnterpriseRepository.java
package com.example.demo.repository;

import com.example.demo.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    
}


