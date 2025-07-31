package com.digipds.transport_item_service.service;

import java.util.List;

import com.digipds.transport_item_service.dto.TransportItemRequestDTO;
import com.digipds.transport_item_service.dto.TransportItemResponseDTO;

public interface TransportItemService {
    TransportItemResponseDTO createTransportItem(TransportItemRequestDTO dto);
    List<TransportItemResponseDTO> getAllTransportItems();
    TransportItemResponseDTO getById(Long id);
    TransportItemResponseDTO updateTransportItem(Long id, TransportItemRequestDTO dto);
    void deleteTransportItem(Long id);

}
