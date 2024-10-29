package com.gold.start.study;

import lombok.val;

import java.util.HashSet;
import java.util.Set;

@lombok.EqualsAndHashCode
public class EqualsAndHashCode {

    private String value;

    public EqualsAndHashCode(String v) {
        this.value  = v;
    }

    public static void main(String[] args) {
        Set<EqualsAndHashCode> set = new HashSet<>();
        set.add(new EqualsAndHashCode("t"));
        set.add(new EqualsAndHashCode("b"));
        set.add(new EqualsAndHashCode("t"));
        set.add(new EqualsAndHashCode("c"));

        System.out.println(set.size());
    }

}
