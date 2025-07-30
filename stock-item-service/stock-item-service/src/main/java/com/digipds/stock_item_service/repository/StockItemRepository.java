package com.digipds.stock_item_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.stock_item_service.entity.StockItem;

public interface StockItemRepository extends JpaRepository<StockItem, Long> {

}
