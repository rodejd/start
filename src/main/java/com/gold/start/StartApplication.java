package com.gold.start;


import com.gold.start.study.*;
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

        Factory factory = FactoryChild::new;
        Factory factory2 =

        factory.createFactory();
        factory2.createFactory();



        System.out.println(CommonUtils.toJson(vo));
        Logger logger = LoggerFactory.getLogger("com.gold.start");
        logger.info("TEST");
        SpringApplication.run(StartApplication.class, args);

    }





}
