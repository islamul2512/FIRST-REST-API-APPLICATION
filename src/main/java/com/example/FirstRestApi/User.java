package com.example.FirstRestApi;

public class User {
    private int userId;
    private String name;
    private int age;

    public User(String name , int age , int userId) {
        this.userId = userId;
        this.name = name;
        this.age = age;

    }

    public User() {  // this is also mandatory

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
}
