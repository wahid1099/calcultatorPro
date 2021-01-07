package com.mahi.sqlitecrudetutorialwithproject.model;

public class Student {
    private int id;
    private String name;
    private String image;
    private String phone;
    private String email;
    private Float cgpa;

    public Student(int id, String name, String image, String phone, String email, Float cgpa) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.email = email;
        this.cgpa = cgpa;
    }

    public Student(String name, String image, String phone, String email, Float cgpa) {
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.email = email;
        this.cgpa = cgpa;
    }

    public Student(String name, String email, String phoneNo, Float cgpa) {
    }

    public Student() {

    }
    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }
}
