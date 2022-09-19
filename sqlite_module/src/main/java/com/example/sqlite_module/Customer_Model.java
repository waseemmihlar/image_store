package com.example.sqlite_module;

public class Customer_Model {
    int id;
    String name;
    int age;
    boolean active;

    public Customer_Model(int id, String name, int age, boolean active) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Setcustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isactive=" + active +
                '}';
    }

    public Customer_Model() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
