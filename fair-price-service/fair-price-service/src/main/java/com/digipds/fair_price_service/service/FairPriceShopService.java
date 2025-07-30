package com.digipds.fair_price_service.service;

import java.util.List;

import com.digipds.fair_price_service.dto.FairPriceShopRequest;
import com.digipds.fair_price_service.dto.FairPriceShopResponse;

public interface FairPriceShopService {

    FairPriceShopResponse createShop(FairPriceShopRequest request);
    List<FairPriceShopResponse> getAllShops();
    FairPriceShopResponse getShopById(Integer id);
    FairPriceShopResponse updateShop(Integer id, FairPriceShopRequest request);
    void deleteShop(Integer id);
}
