package com.gold.start;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {

//        Logger logger = LoggerFactory.getLogger("com.gold.start");
//        logger.info("TEST");
        SpringApplication.run(StartApplication.class, args);

    }





}
