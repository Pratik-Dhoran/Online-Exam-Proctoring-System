package com.exam.online_exam_system.proctoring.controller;

import com.exam.online_exam_system.proctoring.service.ProctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proctor")
public class ProctorController {

    @Autowired
    ProctorService proctorService;

    @PostMapping("/log")
    public void logEvent(@RequestParam Long attemptId,
                         @RequestParam String eventType,
                         @RequestParam String details) {

        proctorService.logEvent(attemptId, eventType, details);
    }
}
