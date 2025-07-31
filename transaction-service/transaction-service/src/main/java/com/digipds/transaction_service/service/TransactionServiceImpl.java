package com.digipds.transaction_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.transaction_service.dto.TransactionRequestDTO;
import com.digipds.transaction_service.dto.TransactionResponseDTO;
import com.digipds.transaction_service.entity.Transaction;
import com.digipds.transaction_service.exception.ResourceNotFoundException;
import com.digipds.transaction_service.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public TransactionResponseDTO createTransaction(TransactionRequestDTO dto) {
        Transaction transaction = Transaction.builder()
                .transactionNumber(dto.getTransactionNumber())
                .fpsId(dto.getFpsId())
                .rationCardId(dto.getRationCardId())
                .servedByUserId(dto.getServedByUserId())
                .transactionType(dto.getTransactionType())
                .totalAmount(dto.getTotalAmount())
                .subsidyAmount(dto.getSubsidyAmount())
                .netPayable(dto.getNetPayable())
                .status(dto.getStatus())
                .transactionDate(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        transaction = transactionRepository.save(transaction);

        return mapToDTO(transaction);
    }

    @Override
    public TransactionResponseDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
        return mapToDTO(transaction);
    }

    @Override
    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO dto) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));

        transaction.setTransactionType(dto.getTransactionType());
        transaction.setFpsId(dto.getFpsId());
        transaction.setRationCardId(dto.getRationCardId());
        transaction.setServedByUserId(dto.getServedByUserId());
        transaction.setTotalAmount(dto.getTotalAmount());
        transaction.setSubsidyAmount(dto.getSubsidyAmount());
        transaction.setNetPayable(dto.getNetPayable());
        transaction.setStatus(dto.getStatus());
        transaction.setUpdatedAt(LocalDateTime.now());

        return mapToDTO(transactionRepository.save(transaction));
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + id));
        transactionRepository.delete(transaction);
    }

    private TransactionResponseDTO mapToDTO(Transaction t) {
        return TransactionResponseDTO.builder()
                .transactionId(t.getTransactionId())
                .transactionNumber(t.getTransactionNumber())
                .fpsId(t.getFpsId())
                .rationCardId(t.getRationCardId())
                .servedByUserId(t.getServedByUserId())
                .transactionType(t.getTransactionType())
                .totalAmount(t.getTotalAmount())
                .subsidyAmount(t.getSubsidyAmount())
                .netPayable(t.getNetPayable())
                .status(t.getStatus())
                .transactionDate(t.getTransactionDate())
                .createdAt(t.getCreatedAt())
                .updatedAt(t.getUpdatedAt())
                .build();
    }

}
