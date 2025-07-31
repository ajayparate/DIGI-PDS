package com.digipds.transport_order_service.dto;

import java.time.LocalDate;

import com.digipds.transport_order_service.entity.TransportStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportOrderRequest {
    private String orderNumber;
    private Long sourceWarehouseId;
    private Long destinationFpsId;
    private String vehicleNumber;
    private String driverName;
    private String driverPhone;
    private LocalDate dispatchDate;
    private LocalDate expectedDeliveryDate;
    private LocalDate actualDeliveryDate;
    private TransportStatus status;

}
