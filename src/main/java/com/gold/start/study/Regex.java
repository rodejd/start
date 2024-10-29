package com.gold.start.study;


import java.util.regex.Pattern;

public class Regex {


//    정규식은 상수화 해서 사용하라!!! 메모리를 많이 처먹는다 비교할떄마다

    // 정규식 상수들
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    public static final String PHONE_NUMBER_REGEX = "^01[016789]-\\d{3,4}-\\d{4}$";
    public static final String INTERNATIONAL_PHONE_REGEX = "^\\+\\d{1,3}\\s?\\d{1,4}\\s?\\d{4,}$";
    public static final String URL_REGEX = "^(https?|ftp)://[A-Za-z0-9.-]+(?:\\.[A-Za-z]{2,})+(?:/.*)?$";
    public static final String IPV4_REGEX = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    public static final String IPV6_REGEX = "([0-9a-fA-F]{1,4}:){7}([0-9a-fA-F]{1,4})";
    public static final String POSTAL_CODE_REGEX = "^\\d{5}$";
    public static final String KOREAN_ID_REGEX = "^\\d{6}-[1-4]\\d{6}$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,}$";
    public static final String NUMBER_REGEX = "^\\d+$";
    public static final String FLOAT_REGEX = "^[+-]?\\d*\\.\\d+$";
    public static final String KOREAN_CHAR_REGEX = "^[가-힣]+$";

    // 정규식을 사용해 유효성 검사
    public static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }
    public static void main(String[] args) {

        System.out.println("이메일 유효성: " + validate("example@domain.com", EMAIL_REGEX));
        System.out.println("전화번호 유효성: " + validate("010-1234-5678", PHONE_NUMBER_REGEX));
        System.out.println("국제 전화번호 유효성: " + validate("+82 10 1234 5678", INTERNATIONAL_PHONE_REGEX));
        System.out.println("URL 유효성: " + validate("https://www.example.com", URL_REGEX));
        System.out.println("IPv4 유효성: " + validate("192.168.0.1", IPV4_REGEX));
        System.out.println("IPv6 유효성: " + validate("2001:0db8:85a3:0000:0000:8a2e:0370:7334", IPV6_REGEX));
        System.out.println("우편번호 유효성: " + validate("12345", POSTAL_CODE_REGEX));
        System.out.println("주민등록번호 유효성: " + validate("900101-1234567", KOREAN_ID_REGEX));
        System.out.println("비밀번호 유효성: " + validate("Password1!", PASSWORD_REGEX));
        System.out.println("숫자만 유효성: " + validate("123456", NUMBER_REGEX));
        System.out.println("실수 유효성: " + validate("123.456", FLOAT_REGEX));
        System.out.println("한글만 유효성: " + validate("안녕하세요", KOREAN_CHAR_REGEX));
    }
}
