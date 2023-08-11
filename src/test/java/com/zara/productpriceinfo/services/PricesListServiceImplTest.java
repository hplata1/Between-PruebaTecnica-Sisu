package com.zara.productpriceinfo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.zara.productpriceinfo.application.usecase.PricesListServiceImpl;
import com.zara.productpriceinfo.domain.PricesModel;
import com.zara.productpriceinfo.infraestructure.dto.PriceResponse;
import com.zara.productpriceinfo.infraestructure.outputadapter.db.PricesRepositoryH2;

public class PricesListServiceImplTest {

    @Mock
    private PricesRepositoryH2 pricesRepository;

    @InjectMocks
    private PricesListServiceImpl pricesListService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetProductPricesWithEmptyList() {
        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        List<PricesModel> pricesList = new ArrayList<>();
        when(pricesRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date)).thenReturn(pricesList);

        PriceResponse priceResponse = pricesListService.getProductPrices(brandId, productId, date);

        assertEquals("1", priceResponse.getStatusCode());
        assertEquals("No se encontró información válida para los datos ingresados", priceResponse.getStatusCodeDesc());
    }

    @Test
    public void testGetProductPricesWithPriority() {
        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 30);

        PricesModel pricesModel1 = new PricesModel();
        pricesModel1.setProductId(productId);
        pricesModel1.setBrandId(brandId);
        pricesModel1.setStartDate(LocalDateTime.of(2020, 6, 14, 00, 0));
        pricesModel1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        pricesModel1.setPrice(30.5);
        pricesModel1.setPriceList(1l);
        pricesModel1.setPriority(0);

        PricesModel pricesModel2 = new PricesModel();
        pricesModel2.setProductId(productId);
        pricesModel2.setBrandId(brandId);
        pricesModel2.setStartDate(LocalDateTime.of(2020, 6, 14, 10, 0));
        pricesModel2.setEndDate(LocalDateTime.of(2020, 6, 14, 12, 00));
        pricesModel2.setPrice(25.45);
        pricesModel2.setPriceList(2l);
        pricesModel2.setPriority(1);


        List<PricesModel> pricesList = new ArrayList<>();
        pricesList.add(pricesModel1);
        pricesList.add(pricesModel2);

        when(pricesRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date)).thenReturn(pricesList);

        PriceResponse priceResponse = pricesListService.getProductPrices(brandId, productId, date);

        assertEquals("0", priceResponse.getStatusCode());
        assertEquals("Transaccion Exitosa", priceResponse.getStatusCodeDesc());
        assertEquals(productId, priceResponse.getProductId());
        assertEquals(brandId, priceResponse.getBrandId());
        assertEquals(25.45, priceResponse.getPrice());
        assertEquals(2, priceResponse.getPriceList());
        assertEquals(date, priceResponse.getDate());
    }


    @Test
    public void testGetProductPricesWithOneList() {
        long brandId = 1;
        long productId = 35455;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 30);

        PricesModel pricesModel1 = new PricesModel();
        pricesModel1.setProductId(productId);
        pricesModel1.setBrandId(brandId);
        pricesModel1.setStartDate(LocalDateTime.of(2020, 6, 14, 00, 0));
        pricesModel1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59));
        pricesModel1.setPrice(30.5);
        pricesModel1.setPriceList(1l);
        pricesModel1.setPriority(0);


        List<PricesModel> pricesList = new ArrayList<>();
        pricesList.add(pricesModel1);

        when(pricesRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date)).thenReturn(pricesList);

        PriceResponse priceResponse = pricesListService.getProductPrices(brandId, productId, date);

        assertEquals("0", priceResponse.getStatusCode());
        assertEquals("Transaccion Exitosa", priceResponse.getStatusCodeDesc());
        assertEquals(productId, priceResponse.getProductId());
        assertEquals(brandId, priceResponse.getBrandId());
        assertEquals(30.5, priceResponse.getPrice());
        assertEquals(1, priceResponse.getPriceList());
        assertEquals(date, priceResponse.getDate());
    }
}
