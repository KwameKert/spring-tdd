package com.codeinsyt.tdd.domains;

public class Car {

    private String name;
    private String type;

    public Car(String name, String type) {

        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
