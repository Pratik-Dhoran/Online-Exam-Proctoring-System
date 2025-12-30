package com.exam.online_exam_system.question.controller;

import com.exam.online_exam_system.question.entity.Option;
import com.exam.online_exam_system.question.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/options")
public class OptionController {

    @Autowired
    OptionService optionService ;

    @PostMapping
    public Option addOption(@RequestBody Option option)
    {
        return optionService.addOption(option) ;
    }
}
