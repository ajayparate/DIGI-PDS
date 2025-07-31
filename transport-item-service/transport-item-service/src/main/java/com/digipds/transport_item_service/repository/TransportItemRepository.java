package com.digipds.transport_item_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.transport_item_service.entity.TransportItem;

public interface TransportItemRepository extends JpaRepository<TransportItem, Long> {
    

}
