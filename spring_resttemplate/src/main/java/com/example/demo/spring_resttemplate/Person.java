package com.example.demo.spring_resttemplate;

import java.io.Serializable;

public class Person implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

}
