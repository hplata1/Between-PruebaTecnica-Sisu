package com.zara.productpriceinfo.application.inputport;

import java.time.LocalDateTime;

import com.zara.productpriceinfo.infraestructure.dto.PriceResponse;

public interface PricesListService  {
    PriceResponse getProductPrices(long brandId, long productId, LocalDateTime date);


}
