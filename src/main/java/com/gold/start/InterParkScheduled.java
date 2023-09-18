package com.gold.start;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class InterParkScheduled {

    @Autowired
    private DaemonService daemonService;


    @Scheduled(cron = "*/2 * * * * *")
    public void interPark() throws MalformedURLException {

        daemonService.callAPi();

    }

}
