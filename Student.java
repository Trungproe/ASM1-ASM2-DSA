package org.example;

class Student {
    private int id;
    private String name;
    private String contactNumber;
    private double score;

    public Student(int id, String name, String contactNumber, double score) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.score = score;
    }

    // Getters and Setters
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Tên: " + name + ", Số điện thoại: " + contactNumber + ", Điểm: " + score;
    }
}