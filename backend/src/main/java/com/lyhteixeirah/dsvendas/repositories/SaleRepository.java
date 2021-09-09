package com.lyhteixeirah.dsvendas.repositories;

import com.lyhteixeirah.dsvendas.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
