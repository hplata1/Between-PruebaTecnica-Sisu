package com.zara.productpriceinfo.infraestructure.inputadapter.http;

import com.zara.productpriceinfo.application.inputport.PricesListService;
import com.zara.productpriceinfo.infraestructure.dto.PriceResponse;
import com.zara.productpriceinfo.infraestructure.dto.PriceResponseError;

import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/v1/ProductPriceInfoInquiry")
@RequiredArgsConstructor
public class ProductPriceInfoAPI {

    private final PricesListService pricesListService;

    @GetMapping(value = "getProductPrice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductPrice(
            @RequestParam("brandId") Long brandId,
            @RequestParam("productId") Long productId,
            @RequestParam("date") LocalDateTime date) {

        PriceResponse priceResponse = pricesListService.getProductPrices(brandId,productId,date);

        if (priceResponse.getStatusCode().equals("1")) {
            PriceResponseError priceResponseError = new PriceResponseError();
            priceResponseError.setStatusCode(priceResponse.getStatusCode());
            priceResponseError.setStatusCodeDesc(priceResponse.getStatusCodeDesc());
            return  ResponseEntity.ok(priceResponseError);
        }else{
            return ResponseEntity.ok(priceResponse);
        }

    }
}
