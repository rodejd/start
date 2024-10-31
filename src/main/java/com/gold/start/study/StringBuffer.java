package com.gold.start.study;

public class StringBuffer {


    public static void main(String[] args) {

        String test = "test";

        System.out.println(test.hashCode());

        test = "b";

        System.out.println(test.hashCode());


        // 멀티 스레드 환경에서는 반드시 StringBuffer
        // 일반 단일 스레드 환경에서는 StringBuilder

        StringBuilder sb = new StringBuilder();

        StringBuffer sf = new StringBuffer();

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                sb.append(" World");
                System.out.println(Thread.currentThread().getName() + ": " + sb.toString());
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();



    }
}
