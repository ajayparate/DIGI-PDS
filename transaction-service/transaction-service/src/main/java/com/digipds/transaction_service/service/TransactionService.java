package com.digipds.transaction_service.service;

import java.util.List;

import com.digipds.transaction_service.dto.TransactionRequestDTO;
import com.digipds.transaction_service.dto.TransactionResponseDTO;

public interface TransactionService {
    TransactionResponseDTO createTransaction(TransactionRequestDTO requestDTO);
    TransactionResponseDTO getTransactionById(Long id);
    List<TransactionResponseDTO> getAllTransactions();
    TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO requestDTO);
    void deleteTransaction(Long id);

}
