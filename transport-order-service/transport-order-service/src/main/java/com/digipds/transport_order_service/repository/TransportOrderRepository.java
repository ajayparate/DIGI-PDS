package com.digipds.transport_order_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.transport_order_service.entity.TransportOrder;

public interface TransportOrderRepository extends JpaRepository<TransportOrder, Long> {
    Optional<TransportOrder> findByOrderNumber (String orderNumber);

}
