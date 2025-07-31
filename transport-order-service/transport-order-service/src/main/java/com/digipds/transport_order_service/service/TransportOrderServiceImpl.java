package com.digipds.transport_order_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.transport_order_service.dto.TransportOrderRequest;
import com.digipds.transport_order_service.dto.TransportOrderResponse;
import com.digipds.transport_order_service.entity.TransportOrder;
import com.digipds.transport_order_service.exception.ResourceNotFoundException;
import com.digipds.transport_order_service.repository.TransportOrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportOrderServiceImpl implements TransportOrderService {

    private final TransportOrderRepository repository;

    @Override
    public TransportOrderResponse createTransportOrder(TransportOrderRequest request) {
        TransportOrder order = TransportOrder.builder()
                .orderNumber(request.getOrderNumber())
                .sourceWarehouseId(request.getSourceWarehouseId())
                .destinationFpsId(request.getDestinationFpsId())
                .vehicleNumber(request.getVehicleNumber())
                .driverName(request.getDriverName())
                .driverPhone(request.getDriverPhone())
                .dispatchDate(request.getDispatchDate())
                .expectedDeliveryDate(request.getExpectedDeliveryDate())
                .actualDeliveryDate(request.getActualDeliveryDate())
                .status(request.getStatus())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        TransportOrder saved = repository.save(order);
        return mapToResponse(saved);
    }

    @Override
    public List<TransportOrderResponse> getAllTransportOrders() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TransportOrderResponse getTransportOrderById(Long id) {
        TransportOrder order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transport Order not found with id: " + id));
        return mapToResponse(order);
    }

    @Override
    public TransportOrderResponse updateTransportOrder(Long id, TransportOrderRequest request) {
        TransportOrder order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transport Order not found with id: " + id));

        order.setOrderNumber(request.getOrderNumber());
        order.setSourceWarehouseId(request.getSourceWarehouseId());
        order.setDestinationFpsId(request.getDestinationFpsId());
        order.setVehicleNumber(request.getVehicleNumber());
        order.setDriverName(request.getDriverName());
        order.setDriverPhone(request.getDriverPhone());
        order.setDispatchDate(request.getDispatchDate());
        order.setExpectedDeliveryDate(request.getExpectedDeliveryDate());
        order.setActualDeliveryDate(request.getActualDeliveryDate());
        order.setStatus(request.getStatus());
        order.setUpdatedAt(LocalDateTime.now());

        TransportOrder updated = repository.save(order);
        return mapToResponse(updated);
    }

    @Override
    public void deleteTransportOrder(Long id) {
        TransportOrder order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transport Order not found with id: " + id));
        repository.delete(order);
    }

    private TransportOrderResponse mapToResponse(TransportOrder order) {
        return TransportOrderResponse.builder()
                .transportOrderId(order.getTransportOrderId())
                .orderNumber(order.getOrderNumber())
                .sourceWarehouseId(order.getSourceWarehouseId())
                .destinationFpsId(order.getDestinationFpsId())
                .vehicleNumber(order.getVehicleNumber())
                .driverName(order.getDriverName())
                .driverPhone(order.getDriverPhone())
                .dispatchDate(order.getDispatchDate())
                .expectedDeliveryDate(order.getExpectedDeliveryDate())
                .actualDeliveryDate(order.getActualDeliveryDate())
                .status(order.getStatus())
                .createdAt(order.getCreatedAt())
                .updatedAt(order.getUpdatedAt())
                .build();
    }

}
