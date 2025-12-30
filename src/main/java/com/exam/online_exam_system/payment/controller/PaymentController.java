package com.exam.online_exam_system.payment.controller;

import com.exam.online_exam_system.auth.jwt.JwtUtil;
import com.exam.online_exam_system.payment.entity.Payment;
import com.exam.online_exam_system.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/pay")
    public Payment pay(@RequestParam double amount,
                       @RequestParam String product,
                       @RequestHeader("Authorization") String authHeader) {

        String token = authHeader.substring(7);
        String email = JwtUtil.extractEmail(token);

        return paymentService.makePayment(email, amount, product);
    }
}
