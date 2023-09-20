package com.gold.start.reservation;


import com.gold.start.reservation.service.DaemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.util.Date;

@Component
@Slf4j
public class InterParkScheduled {

    @Autowired
    private DaemonService daemonService;


    @Scheduled(cron = "0 * * * * *")
    public void health() throws MalformedURLException {

        Date date = new Date();


        log.info(String.valueOf(date.getTime()));
//        daemonService.telegram("[서비스 정상 기동중]");

    }


//    @Scheduled(cron = "*/10 * * * * *")
    public void interPark14() throws MalformedURLException {

        daemonService.callAPi("https://api-ticketfront.interpark.com/v1/goods/21005592/playSeq/PlaySeq/745/REMAINSEAT");

    }

//    @Scheduled(cron = "*/15 * * * * *")
    public void interPark21() throws MalformedURLException {

        daemonService.callAPi("https://api-ticketfront.interpark.com/v1/goods/21005592/playSeq/PlaySeq/751/REMAINSEAT");

    }


//    @Scheduled(cron = "*/13 * * * * *")
    public void interPark28() throws MalformedURLException {

        daemonService.callAPi("https://api-ticketfront.interpark.com/v1/goods/21005592/playSeq/PlaySeq/758/REMAINSEAT");

    }

}
