package com.digipds.transport_item_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.transport_item_service.dto.TransportItemRequestDTO;
import com.digipds.transport_item_service.dto.TransportItemResponseDTO;
import com.digipds.transport_item_service.entity.TransportItem;
import com.digipds.transport_item_service.exception.ResourceNotFoundException;
import com.digipds.transport_item_service.repository.TransportItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportItemServiceImpl implements TransportItemService {



    private final TransportItemRepository repository;

    @Override
    public TransportItemResponseDTO createTransportItem(TransportItemRequestDTO dto) {
        TransportItem item = TransportItem.builder()
                .transportOrderId(dto.getTransportOrderId())
                .commodityId(dto.getCommodityId())
                .quantityDispatched(dto.getQuantityDispatched())
                .quantityReceived(dto.getQuantityReceived())
                .batchNumber(dto.getBatchNumber())
                .conditionOnDelivery(dto.getConditionOnDelivery())
                .build();

        TransportItem saved = repository.save(item);
        return mapToDTO(saved);
    }

    @Override
    public List<TransportItemResponseDTO> getAllTransportItems() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TransportItemResponseDTO getById(Long id) {
        TransportItem item = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transport Item not found with id: " + id));
        return mapToDTO(item);
    }

    @Override
    public TransportItemResponseDTO updateTransportItem(Long id, TransportItemRequestDTO dto) {
        TransportItem item = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transport Item not found with id: " + id));

        item.setTransportOrderId(dto.getTransportOrderId());
        item.setCommodityId(dto.getCommodityId());
        item.setQuantityDispatched(dto.getQuantityDispatched());
        item.setQuantityReceived(dto.getQuantityReceived());
        item.setBatchNumber(dto.getBatchNumber());
        item.setConditionOnDelivery(dto.getConditionOnDelivery());

        return mapToDTO(repository.save(item));
    }

    @Override
    public void deleteTransportItem(Long id) {
        repository.deleteById(id);
    }

    private TransportItemResponseDTO mapToDTO(TransportItem item) {
        return TransportItemResponseDTO.builder()
                .transportItemId(item.getTransportItemId())
                .transportOrderId(item.getTransportOrderId())
                .commodityId(item.getCommodityId())
                .quantityDispatched(item.getQuantityDispatched())
                .quantityReceived(item.getQuantityReceived())
                .batchNumber(item.getBatchNumber())
                .conditionOnDelivery(item.getConditionOnDelivery())
                .build();
    }

}
