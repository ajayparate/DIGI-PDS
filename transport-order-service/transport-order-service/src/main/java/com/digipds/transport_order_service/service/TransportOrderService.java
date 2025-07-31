package com.digipds.transport_order_service.service;

import java.util.List;

import com.digipds.transport_order_service.dto.TransportOrderRequest;
import com.digipds.transport_order_service.dto.TransportOrderResponse;

public interface TransportOrderService {
    TransportOrderResponse createTransportOrder(TransportOrderRequest request);
    List<TransportOrderResponse> getAllTransportOrders();
    TransportOrderResponse getTransportOrderById(Long id);
    TransportOrderResponse updateTransportOrder(Long id, TransportOrderRequest request);
    void deleteTransportOrder(Long id);

}
