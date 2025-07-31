package com.digipds.transaction_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.transaction_service.dto.APIResponseDTO;
import com.digipds.transaction_service.dto.TransactionRequestDTO;
import com.digipds.transaction_service.dto.TransactionResponseDTO;
import com.digipds.transaction_service.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<APIResponseDTO> create(@RequestBody TransactionRequestDTO dto) {
        // return new ResponseEntity<>(transactionService.createTransaction(dto), HttpStatus.CREATED);
        TransactionResponseDTO responseDTO = transactionService.createTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(APIResponseDTO.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Transaction has Been Done Successfully.")
                .timestamp(LocalDateTime.now())
                .data(responseDTO)
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> getAll() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponseDTO> update(@PathVariable Long id, @RequestBody TransactionRequestDTO dto) {
        return ResponseEntity.ok(transactionService.updateTransaction(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO> delete(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Transaction deleted successfully")
                .timestamp(LocalDateTime.now())
                .build());
    }

}
