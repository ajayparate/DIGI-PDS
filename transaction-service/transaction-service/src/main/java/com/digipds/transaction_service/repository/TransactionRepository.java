package com.digipds.transaction_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.transaction_service.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByTransactionNumber(String transactionNumber);

}
