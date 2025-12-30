package com.exam.online_exam_system.payment.entity;

import com.exam.online_exam_system.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private double amount;
    private String productName;
    private String status; // SUCCESS, FAILED

    private LocalDateTime createdAt;
}
