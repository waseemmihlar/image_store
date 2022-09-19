package com.example.custom_adapterview2;

public class person_det {

    String name,address;
    int telno;

    public person_det(String name, String address, int telno) {
        this.name = name;
        this.address = address;
        this.telno = telno;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getTelno() {
        return telno;
    }
}
