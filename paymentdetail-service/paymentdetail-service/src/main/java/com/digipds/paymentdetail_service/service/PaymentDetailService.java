package com.digipds.paymentdetail_service.service;

import java.util.List;

import com.digipds.paymentdetail_service.dto.PaymentDetailRequestDTO;
import com.digipds.paymentdetail_service.dto.PaymentDetailResponseDTO;

public interface PaymentDetailService {
    PaymentDetailResponseDTO create(PaymentDetailRequestDTO dto);
    PaymentDetailResponseDTO getById(Long id);
    List<PaymentDetailResponseDTO> getAll();
    PaymentDetailResponseDTO update(Long id, PaymentDetailRequestDTO dto);
    void delete(Long id);

}
