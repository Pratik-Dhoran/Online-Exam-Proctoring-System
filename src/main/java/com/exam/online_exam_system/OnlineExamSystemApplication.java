package com.exam.online_exam_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class OnlineExamSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExamSystemApplication.class, args);
	}

}
