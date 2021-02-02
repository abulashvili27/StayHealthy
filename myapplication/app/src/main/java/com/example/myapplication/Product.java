package com.example.myapplication;

public class Product {

    private String name, email, gender;
    private int age, height, weight;

    public Product(){

    }

    public Product(String name, String email, String gender, int age, int height, int weight) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}
