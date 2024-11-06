package com.gold.start.study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Lambda {


    public static void main(String[] args) {
        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Old Runnable is running");
            }
        };

        // 람다식 방식
        Runnable lambdaRunnable = () -> System.out.println("TEST");

        // 스레드 실행
        new Thread(oldRunnable).start();
        new Thread(lambdaRunnable).start();



        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // 기존 방식
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println(names);


        Supplier<String> test = () -> "ABC";

        System.out.println(test.get());


    }
}
