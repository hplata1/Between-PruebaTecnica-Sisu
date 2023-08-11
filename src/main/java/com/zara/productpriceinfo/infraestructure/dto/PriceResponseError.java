package com.zara.productpriceinfo.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponseError {

    private String statusCode;
    private String statusCodeDesc;
}
