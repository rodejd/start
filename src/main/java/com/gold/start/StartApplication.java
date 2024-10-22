package com.gold.start;


import com.gold.start.study.CommonUtils;
import com.gold.start.study.StudyVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {


        StudyVo vo = StudyVo.getInstance();


        System.out.println(CommonUtils.toJson(vo));
        Logger logger = LoggerFactory.getLogger("com.gold.start");
        logger.info("TEST");
        SpringApplication.run(StartApplication.class, args);

    }





}
