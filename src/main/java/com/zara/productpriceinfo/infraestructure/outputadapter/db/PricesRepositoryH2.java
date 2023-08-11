package com.zara.productpriceinfo.infraestructure.outputadapter.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zara.productpriceinfo.domain.PricesModel;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepositoryH2  extends JpaRepository<PricesModel,Long>{

    @Query("SELECT p FROM PricesModel p WHERE p.brandId = :brandId AND p.productId = :productId AND :inputDate BETWEEN p.startDate AND p.endDate")
    List<PricesModel> findByProductIdAndBrandIdAndDate(@Param("productId") Long productId, @Param("brandId")Long brandId, @Param("inputDate") LocalDateTime inputDate);
}
