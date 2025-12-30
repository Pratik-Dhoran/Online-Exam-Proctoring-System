package com.exam.online_exam_system.payment.service;

import com.exam.online_exam_system.payment.entity.Payment;

public interface PaymentService {
    Payment makePayment(String email, double amount, String product);
}
