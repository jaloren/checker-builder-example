package com.test.checker.builder;

public class Application {

    public static void main(String[] args) {
        Person p = new Person.Builder()
            .setGender("male")
            .setName("john doe")
            .build();
        System.out.println(p);
    }
}
