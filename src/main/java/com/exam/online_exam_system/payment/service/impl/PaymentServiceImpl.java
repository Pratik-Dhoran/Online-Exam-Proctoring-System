package com.exam.online_exam_system.payment.service.impl;

import com.exam.online_exam_system.common.exception.ApiException;
import com.exam.online_exam_system.payment.entity.Payment;
import com.exam.online_exam_system.payment.repository.PaymentRepository;
import com.exam.online_exam_system.payment.service.PaymentService;
import com.exam.online_exam_system.user.entity.User;
import com.exam.online_exam_system.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public Payment makePayment(String email, double amount, String product) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ApiException("User not found"));

        Payment payment = new Payment();
        payment.setUser(user);
        payment.setAmount(amount);
        payment.setProductName(product);
        payment.setStatus("SUCCESS");
        payment.setCreatedAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}
