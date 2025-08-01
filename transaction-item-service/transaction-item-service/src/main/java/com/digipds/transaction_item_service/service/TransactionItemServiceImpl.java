package com.digipds.transaction_item_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.transaction_item_service.dto.TransactionItemRequestDTO;
import com.digipds.transaction_item_service.dto.TransactionItemResponseDTO;
import com.digipds.transaction_item_service.entity.TransactionItem;
import com.digipds.transaction_item_service.exception.ResourceNotFoundException;
import com.digipds.transaction_item_service.repository.TransactionItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionItemServiceImpl implements TransactionItemService {

    private final TransactionItemRepository repository;

    @Override
    public TransactionItemResponseDTO create(TransactionItemRequestDTO dto) {
        TransactionItem item = TransactionItem.builder()
                .transactionId(dto.getTransactionId())
                .commodityId(dto.getCommodityId())
                .quantityPurchased(dto.getQuantityPurchased())
                .unitPrice(dto.getUnitPrice())
                .subsidizedPrice(dto.getSubsidizedPrice())
                .lineTotal(dto.getSubsidizedPrice().multiply(dto.getQuantityPurchased()))
                .build();
        TransactionItem saved = repository.save(item);
        return mapToDTO(saved);
    }

    @Override
    public TransactionItemResponseDTO getById(Long id) {
        TransactionItem item = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction item not found"));
        return mapToDTO(item);
    }

    @Override
    public List<TransactionItemResponseDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionItemResponseDTO update(Long id, TransactionItemRequestDTO dto) {
        TransactionItem item = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction item not found"));

        item.setTransactionId(dto.getTransactionId());
        item.setCommodityId(dto.getCommodityId());
        item.setQuantityPurchased(dto.getQuantityPurchased());
        item.setUnitPrice(dto.getUnitPrice());
        item.setSubsidizedPrice(dto.getSubsidizedPrice());
        item.setLineTotal(dto.getSubsidizedPrice().multiply(dto.getQuantityPurchased()));

        return mapToDTO(repository.save(item));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TransactionItemResponseDTO mapToDTO(TransactionItem item) {
        return TransactionItemResponseDTO.builder()
                .transactionItemId(item.getTransactionItemId())
                .transactionId(item.getTransactionId())
                .commodityId(item.getCommodityId())
                .quantityPurchased(item.getQuantityPurchased())
                .unitPrice(item.getUnitPrice())
                .subsidizedPrice(item.getSubsidizedPrice())
                .lineTotal(item.getLineTotal())
                .build();
    }


}
