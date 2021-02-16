package com.test.checker.builder;

import org.checkerframework.checker.calledmethods.qual.CalledMethods;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.common.returnsreceiver.qual.This;

public class Person {

    private final String name;
    private final String gender;

    private Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + this.name + '\'' +
            ", gender='" + this.gender + '\'' +
            '}';
    }

    public static class Builder {

        private @MonotonicNonNull String name;

        private @MonotonicNonNull String gender;

        public @EnsuresNonNull("name")
        @This Builder setName(String value) {
            this.name = value;
            return this;
        }

        public @EnsuresNonNull("gender")
        @This Builder setGender(String value) {
            this.gender = value;
            return this;
        }

        public @RequiresNonNull({"name", "gender"}) Person build(@CalledMethods({"setName", "setGender"}) Builder this) {
            return new Person(this.name, this.gender);
        }
    }
}
