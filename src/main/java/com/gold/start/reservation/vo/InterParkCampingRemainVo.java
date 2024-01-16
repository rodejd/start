package com.gold.start.reservation.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class InterParkCampingRemainVo {

    private Common common;
    private Data data;

    @lombok.Data
    public static class Common {
        private String messageId;
        private String message;
        private String requestUri;
        private String gtid;
        private String timestamp;
        private int internalHttpStatusCode;

        // Getter, Setter, toString 등의 메서드 추가
    }

    @lombok.Data
    public static class Data {
        private List<RemainSeat> remainSeat;

        @lombok.Data
        public static class RemainSeat {
            @JsonProperty("playSeq")
            private String playSeq;
            private String seatGrade;
            private String seatGradeName;
            private String remainCnt;

            // Getter, Setter, toString 등의 메서드 추가
        }

        // Getter, Setter, toString 등의 메서드 추가
    }

}
