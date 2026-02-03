package com.exam.online_exam_system.payment.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private static final String KEY_ID = "rzp_test_SBYPI5bpzVBkkN";
    private static final String KEY_SECRET = "oMyNs5x1wRy4AcknP4YcA2Gt";

    @PostMapping("/create-order")
    public String createOrder(@RequestBody Map<String, Object> body) throws Exception {

        int amount = (int) body.get("amount");

        RazorpayClient client = new RazorpayClient(KEY_ID, KEY_SECRET);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "COURSE_" + System.currentTimeMillis());

        Order order = client.orders.create(orderRequest);

        return order.toString();
    }
}
