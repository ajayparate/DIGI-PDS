package com.digipds.transaction_item_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.transaction_item_service.entity.TransactionItem;

public interface TransactionItemRepository extends JpaRepository<TransactionItem,Long> {

    
}
