package com.digipds.transaction_item_service.service;

import java.util.List;

import com.digipds.transaction_item_service.dto.TransactionItemRequestDTO;
import com.digipds.transaction_item_service.dto.TransactionItemResponseDTO;

public interface TransactionItemService {
    TransactionItemResponseDTO create(TransactionItemRequestDTO dto);
    TransactionItemResponseDTO getById(Long id);
    List<TransactionItemResponseDTO> getAll();
    TransactionItemResponseDTO update(Long id, TransactionItemRequestDTO dto);
    void delete(Long id);

}
