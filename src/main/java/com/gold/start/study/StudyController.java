package com.gold.start.study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyController {


    @Autowired
    private StudyService studyService;

    @GetMapping("/v1/test")
    public void test() {




        studyService.test();
    }
}
