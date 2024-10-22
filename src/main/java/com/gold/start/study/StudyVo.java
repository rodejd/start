package com.gold.start.study;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class StudyVo {

    private String name;
    private String test;

    // 싱글턴 인스턴스
    private static final StudyVo instance = new StudyVo();

    // 인스턴스를 반환하는 메서드
    public static StudyVo getInstance() {
        return instance;
    }

    // Getter와 Setter 추가 (Lombok으로 자동 생성 가능)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
