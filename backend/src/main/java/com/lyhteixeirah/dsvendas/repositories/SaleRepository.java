package com.lyhteixeirah.dsvendas.repositories;

import java.util.List;

import com.lyhteixeirah.dsvendas.dto.SaleSuccessDTO;
import com.lyhteixeirah.dsvendas.dto.SaleSumDTO;
import com.lyhteixeirah.dsvendas.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    /**Donut Chart*/
    @Query("SELECT new com.lyhteixeirah.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller();

    /**Bar Chart */
    @Query("SELECT new com.lyhteixeirah.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) FROM Sale AS obj GROUP BY obj.seller")
    List<SaleSuccessDTO> successGroupedBySeller();
}
