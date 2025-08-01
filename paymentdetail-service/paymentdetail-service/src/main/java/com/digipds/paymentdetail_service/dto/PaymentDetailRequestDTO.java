package com.digipds.paymentdetail_service.dto;

import java.time.LocalDateTime;

import com.digipds.paymentdetail_service.entity.PaymentMethod;
import com.digipds.paymentdetail_service.entity.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDetailRequestDTO {
    private Long transactionId;
    private PaymentMethod paymentMethod;
    private String paymentGatewayId;
    private String paymentReferenceNumber;
    private String qrCodeData;
    private String upiId;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentTimestamp;
    private String gatewayResponse;

}
