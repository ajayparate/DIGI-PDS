package com.digipds.paymentdetail_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.paymentdetail_service.dto.PaymentDetailRequestDTO;
import com.digipds.paymentdetail_service.dto.PaymentDetailResponseDTO;
import com.digipds.paymentdetail_service.entity.PaymentDetail;
import com.digipds.paymentdetail_service.exception.ResourceNotFoundException;
import com.digipds.paymentdetail_service.repository.PaymentDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentDetailServiceImpl implements PaymentDetailService{
    private final PaymentDetailRepository repository;

    @Override
    public PaymentDetailResponseDTO create(PaymentDetailRequestDTO dto) {
        PaymentDetail detail = PaymentDetail.builder()
            .transactionId(dto.getTransactionId())
            .paymentMethod(dto.getPaymentMethod())
            .paymentGatewayId(dto.getPaymentGatewayId())
            .paymentReferenceNumber(dto.getPaymentReferenceNumber())
            .qrCodeData(dto.getQrCodeData())
            .upiId(dto.getUpiId())
            .paymentStatus(dto.getPaymentStatus())
            .paymentTimestamp(dto.getPaymentTimestamp())
            .gatewayResponse(dto.getGatewayResponse())
            .createdAt(LocalDateTime.now())
            .build();

        PaymentDetail saved = repository.save(detail);

        return toResponseDTO(saved);
    }

    @Override
    public PaymentDetailResponseDTO getById(Long id) {
        return toResponseDTO(
            repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"))
        );
    }

    @Override
    public List<PaymentDetailResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toResponseDTO)
            .collect(Collectors.toList());
    }

    @Override
    public PaymentDetailResponseDTO update(Long id, PaymentDetailRequestDTO dto) {
        PaymentDetail detail = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        detail.setPaymentStatus(dto.getPaymentStatus());
        detail.setPaymentReferenceNumber(dto.getPaymentReferenceNumber());
        detail.setGatewayResponse(dto.getGatewayResponse());
        detail.setPaymentTimestamp(dto.getPaymentTimestamp());

        return toResponseDTO(repository.save(detail));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PaymentDetailResponseDTO toResponseDTO(PaymentDetail detail) {
        return PaymentDetailResponseDTO.builder()
            .paymentId(detail.getPaymentId())
            .transactionId(detail.getTransactionId())
            .paymentMethod(detail.getPaymentMethod())
            .paymentReferenceNumber(detail.getPaymentReferenceNumber())
            .paymentStatus(detail.getPaymentStatus())
            .paymentTimestamp(detail.getPaymentTimestamp())
            .build();
    }


}
