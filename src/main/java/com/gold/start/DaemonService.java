package com.gold.start;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

@Service
@Slf4j
public class DaemonService {

    public void callAPi(String url) throws MalformedURLException {

        try {
            URL tempUrl = new URL(url);

            // HttpURLConnection을 열고 설정합니다.
            HttpURLConnection conn = (HttpURLConnection) tempUrl.openConnection();
            conn.setRequestMethod("GET"); // HTTP GET 요청을 보냅니다.

            // 응답 본문을 읽어옵니다.
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            ObjectMapper objectMapper =
                    new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            InterParkCampingRemainVo interParkCampingRemainVo = objectMapper.readValue(response.toString(), InterParkCampingRemainVo.class);
            for(int i = 0; i < interParkCampingRemainVo.getData().getRemainSeat().size(); i++){
                if(interParkCampingRemainVo.getData().getRemainSeat().get(i).getSeatGrade().equals("1") || interParkCampingRemainVo.getData().getRemainSeat().get(i).getSeatGrade().equals("2")){
                    if(!interParkCampingRemainVo.getData().getRemainSeat().get(i).getRemainCnt().equals("0")){
                        String tempDate  = "";
                        switch(interParkCampingRemainVo.getData().getRemainSeat().get(i).getPlaySeq()){
                            case "745":
                                tempDate = "14일";
                                break;
                            case "751":
                                tempDate = "21일";
                                break;
                            case "758":
                                tempDate = "28일";
                                break;
                        };
                        telegram( "===================자리 발생====================");
                        telegram( "[ " + tempDate + "]"+interParkCampingRemainVo.getData().getRemainSeat().get(i).getSeatGradeName() + " 잔여 자리 = " + interParkCampingRemainVo.getData().getRemainSeat().get(i).getRemainCnt());
                        telegram( "===================빨리 빨리====================");
                    }
                }
            }

        }catch (Exception e){
            log.error("ERROR {} ", e);
        }
    }


    public void telegram(String msg){

        String Token = "6433623813:AAEaZ-18UrwAkdv8eF1U9p2FzWnjpqB78oQ";
        String chat_id = "6613664655";
        String text = msg;

        BufferedReader in = null;

        try {
            URL obj = new URL("https://api.telegram.org/bot" + Token + "/sendmessage?chat_id=" + chat_id + "&text=" + text); // 호출할 url

            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("GET");
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line;

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) try { in.close(); } catch(Exception e) { e.printStackTrace(); }
        }
    }

    public void interPark(){}

}
