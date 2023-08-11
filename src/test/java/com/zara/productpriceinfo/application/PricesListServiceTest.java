package com.zara.productpriceinfo.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zara.productpriceinfo.application.inputport.PricesListService;
import com.zara.productpriceinfo.infraestructure.dto.PriceResponse;
import com.zara.productpriceinfo.infraestructure.dto.PriceResponseError;
import com.zara.productpriceinfo.infraestructure.inputadapter.http.ProductPriceInfoAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesListServiceTest {

    @Mock
    private PricesListService pricesListService;

    @InjectMocks
    private ProductPriceInfoAPI priceController;

    @Test
    public void getProductPriceTestOK_Date1() throws JsonProcessingException {

        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        PriceResponse expectedResponse = new PriceResponse();
        expectedResponse.setStatusCode("0");
        expectedResponse.setStatusCodeDesc("Transaccion Exitosa");
        expectedResponse.setProductId(35455L);
        expectedResponse.setPrice(35.5);
        expectedResponse.setDate(LocalDateTime.parse("2020-06-14T10:00:00"));
        expectedResponse.setPriceList(1L);
        expectedResponse.setBrandId(1L);

        when(pricesListService.getProductPrices(brandId, productId, date)).thenReturn(expectedResponse);

        ResponseEntity<?> response = priceController.getProductPrice(brandId, productId, date);
        PriceResponse priceEntityResp = (PriceResponse) response.getBody();
        double price = priceEntityResp.getPrice();
        String statusCode = priceEntityResp.getStatusCode();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(response),
                () -> Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue()),
                () -> Assertions.assertEquals("0", statusCode),
                () -> Assertions.assertEquals(35.5, price)
        );
    }

    @Test
    public void getProductPriceTestOK_Date2() throws JsonProcessingException {

        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0);

        PriceResponse expectedResponse = new PriceResponse();
        expectedResponse.setStatusCode("0");
        expectedResponse.setStatusCodeDesc("Transaccion Exitosa");
        expectedResponse.setProductId(35455L);
        expectedResponse.setPrice(25.45);
        expectedResponse.setDate(LocalDateTime.parse("2020-06-14T16:00:00"));
        expectedResponse.setPriceList(2L);
        expectedResponse.setBrandId(1L);

        when(pricesListService.getProductPrices(brandId, productId, date)).thenReturn(expectedResponse);

        ResponseEntity<?> response = priceController.getProductPrice(brandId, productId, date);
        PriceResponse priceEntityResp = (PriceResponse) response.getBody();
        double price = priceEntityResp.getPrice();
        String statusCode = priceEntityResp.getStatusCode();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(response),
                () -> Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue()),
                () -> Assertions.assertEquals("0", statusCode),
                () -> Assertions.assertEquals(25.45, price)
        );
    }

    @Test
    public void getProductPriceTestOK_Date3() throws JsonProcessingException {

        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0);

        PriceResponse expectedResponse = new PriceResponse();
        expectedResponse.setStatusCode("0");
        expectedResponse.setStatusCodeDesc("Transaccion Exitosa");
        expectedResponse.setProductId(35455L);
        expectedResponse.setPrice(35.5);
        expectedResponse.setDate(LocalDateTime.parse("2020-06-14T21:00:00"));
        expectedResponse.setPriceList(2L);
        expectedResponse.setBrandId(1L);

        when(pricesListService.getProductPrices(brandId, productId, date)).thenReturn(expectedResponse);

        ResponseEntity<?> response = priceController.getProductPrice(brandId, productId, date);
        PriceResponse priceEntityResp = (PriceResponse) response.getBody();
        double price = priceEntityResp.getPrice();
        String statusCode = priceEntityResp.getStatusCode();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(response),
                () -> Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue()),
                () -> Assertions.assertEquals("0", statusCode),
                () -> Assertions.assertEquals(35.5, price)
        );
    }

    @Test
    public void getProductPriceTestOK_Date4() throws JsonProcessingException {

        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0);

        PriceResponse expectedResponse = new PriceResponse();
        expectedResponse.setStatusCode("0");
        expectedResponse.setStatusCodeDesc("Transaccion Exitosa");
        expectedResponse.setProductId(35455L);
        expectedResponse.setPrice(30.5);
        expectedResponse.setDate(LocalDateTime.parse("2020-06-15T10:00:00"));
        expectedResponse.setPriceList(2L);
        expectedResponse.setBrandId(1L);

        when(pricesListService.getProductPrices(brandId, productId, date)).thenReturn(expectedResponse);

        ResponseEntity<?> response = priceController.getProductPrice(brandId, productId, date);
        PriceResponse priceEntityResp = (PriceResponse) response.getBody();
        double price = priceEntityResp.getPrice();
        String statusCode = priceEntityResp.getStatusCode();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(response),
                () -> Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue()),
                () -> Assertions.assertEquals("0", statusCode),
                () -> Assertions.assertEquals(30.5, price)
        );
    }

    @Test
    public void getProductPriceTestOK_Date5() throws JsonProcessingException {

        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0);

        PriceResponse expectedResponse = new PriceResponse();
        expectedResponse.setStatusCode("0");
        expectedResponse.setStatusCodeDesc("Transaccion Exitosa");
        expectedResponse.setProductId(35455L);
        expectedResponse.setPrice(38.95);
        expectedResponse.setDate(LocalDateTime.parse("2020-06-16T21:00:00"));
        expectedResponse.setPriceList(2L);
        expectedResponse.setBrandId(1L);

        when(pricesListService.getProductPrices(brandId, productId, date)).thenReturn(expectedResponse);

        ResponseEntity<?> response = priceController.getProductPrice(brandId, productId, date);
        PriceResponse priceEntityResp = (PriceResponse) response.getBody();
        double price = priceEntityResp.getPrice();
        String statusCode = priceEntityResp.getStatusCode();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(response),
                () -> Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue()),
                () -> Assertions.assertEquals("0", statusCode),
                () -> Assertions.assertEquals(38.95, price)
        );
    }

    @Test
    public void getProductPriceTestFault() throws JsonProcessingException {

        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0);

        PriceResponse expectedResponse = new PriceResponse();
        expectedResponse.setStatusCode("1");
        expectedResponse.setStatusCodeDesc("No se encontró información válida para los datos ingresados");

        when(pricesListService.getProductPrices(brandId, productId, date)).thenReturn(expectedResponse);

        ResponseEntity<?> response = priceController.getProductPrice(brandId, productId, date);
        PriceResponseError priceEntityResp = (PriceResponseError) response.getBody();
        String statusCode = priceEntityResp.getStatusCode();

        Assertions.assertAll(
                () -> Assertions.assertNotNull(response),
                () -> Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue()),
                () -> Assertions.assertEquals("1", statusCode)
        );
    }


}
