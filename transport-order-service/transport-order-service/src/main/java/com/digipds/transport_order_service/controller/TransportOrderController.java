package com.digipds.transport_order_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.transport_order_service.dto.APIResponseDTO;
import com.digipds.transport_order_service.dto.TransportOrderRequest;
import com.digipds.transport_order_service.dto.TransportOrderResponse;
import com.digipds.transport_order_service.service.TransportOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transport-orders")
@RequiredArgsConstructor
public class TransportOrderController {
    private final TransportOrderService transportOrderService;

    @PostMapping
    public ResponseEntity<APIResponseDTO> createOrder(@RequestBody TransportOrderRequest request) {
        TransportOrderResponse response = transportOrderService.createTransportOrder(request);
        return ResponseEntity
                .status(201)
                .body(APIResponseDTO.builder()
                        .statusCode(201)
                        .message("Transport Order created successfully.")
                        .timestamp(LocalDateTime.now())
                        .data(response)
                        .build());
    }

    @GetMapping
    public ResponseEntity<List<TransportOrderResponse>> getAllOrders() {
        return ResponseEntity.ok(transportOrderService.getAllTransportOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransportOrderResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(transportOrderService.getTransportOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponseDTO> updateOrder(
            @PathVariable Long id,
            @RequestBody TransportOrderRequest request
    ) {
        TransportOrderResponse response = transportOrderService.updateTransportOrder(id, request);
        return ResponseEntity.ok(
                APIResponseDTO.builder()
                        .statusCode(200)
                        .message("Transport Order updated successfully.")
                        .timestamp(LocalDateTime.now())
                        .data(response)
                        .build()
        );
    }
            
    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO> delete(@PathVariable Long id) {
        transportOrderService.deleteTransportOrder(id);
        return ResponseEntity.ok(
                APIResponseDTO.builder()
                        .statusCode(200)
                        .message("Transport Order deleted successfully.")
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
