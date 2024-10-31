package com.gold.start.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age); // 나이를 기준으로 비교
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }


    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // 나이를 기준으로 정렬
        Collections.sort(people);

        // 정렬된 결과 출력
        for (Person person : people) {
            System.out.println(person);
        }
    }
}

