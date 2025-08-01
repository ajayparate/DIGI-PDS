package com.digipds.paymentdetail_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.paymentdetail_service.entity.PaymentDetail;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
    

}
