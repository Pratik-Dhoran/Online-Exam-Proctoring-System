package com.exam.online_exam_system.attempt.scheduler;

import com.exam.online_exam_system.attempt.entity.Attempt;
import com.exam.online_exam_system.attempt.repository.AttemptRepository;
import com.exam.online_exam_system.result.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ExamTimeoutScheduler {

    @Autowired
    AttemptRepository attemptRepository;
    @Autowired
    ResultService resultService;


    @Scheduled(fixedRate = 60000)
    public void checkTimeouts() {

        List<Attempt> attempts = attemptRepository.findAll();

        for (Attempt attempt : attempts) {

            if (attempt.getStatus().equals("IN_PROGRESS")) {

                LocalDateTime endTime = attempt.getStartTime()
                        .plusMinutes(attempt.getExam().getDurationMinutes());

                if (LocalDateTime.now().isAfter(endTime)) {
                    attempt.setStatus("TIMEOUT");
                    attempt.setEndTime(LocalDateTime.now());
                    attemptRepository.save(attempt);
                    resultService.evaluateResult(attempt.getId());
                }
            }
        }
    }
}
