package com.zara.productpriceinfo.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponse {

    private String statusCode;
    private String statusCodeDesc;
    private Long brandId;
    private LocalDateTime date;
    private Long priceList;
    private Long productId;
    private Double price;
}
