package com.gold.start;


import com.gold.start.reservation.service.DaemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;

@Component
public class InterParkScheduled {

    @Autowired
    private DaemonService daemonService;


    @Scheduled(cron = "0 0 0/1 * * *")
    public void health() throws MalformedURLException {
        daemonService.telegram("[캠핑 알리미 서버 정상 기동중]");
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void interPark14() throws MalformedURLException {
        daemonService.callAPi("https://api-ticketfront.interpark.com/v1/goods/21005592/playSeq/PlaySeq/928/REMAINSEAT");
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
