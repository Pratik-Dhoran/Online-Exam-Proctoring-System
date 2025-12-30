package com.exam.online_exam_system.question.service.impl;

import com.exam.online_exam_system.question.entity.Option;
import com.exam.online_exam_system.question.repository.OptionRepository;
import com.exam.online_exam_system.question.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    OptionRepository optionRepository ;

    @Override
    public Option addOption(Option option)
    {
        return optionRepository.save(option) ;
    }
}
