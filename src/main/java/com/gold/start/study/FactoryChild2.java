package com.gold.start.study;


public class FactoryChild2 implements Factory {

    public FactoryChild2() {
        System.out.println("팩토리 2번 생성");
    }

    @Override
    public Factory createFactory() {
        return new FactoryChild2();
    }




}
