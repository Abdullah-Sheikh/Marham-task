package com.example.marham.models;

public class Question {

    String title, query, time, city, askingFor, gender;
    int age , image;

    public Question() {
    }

    public Question(String title, String query, String time, String city, String askingFor, String gender, int image, int age) {
        this.title = title;
        this.query = query;
        this.time = time;
        this.city = city;
        this.askingFor = askingFor;
        this.gender = gender;
        this.image = image;
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAskingFor() {
        return askingFor;
    }

    public void setAskingFor(String askingFor) {
        this.askingFor = askingFor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}