package com.gold.start;


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
        daemonService.telegram("[AWS 프로젝트 Back-End 서버 정상 기동중]");
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
