package com.gold.start.study;


public class FactoryChild implements Factory {

    public FactoryChild() {
        System.out.println("1번 생성");
    }

    @Override
    public Factory createFactory() {
        return new FactoryChild();
    }




}
