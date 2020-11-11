package com.atta.softagi;

import java.io.Serializable;

public class User implements Serializable {

    String name, phone, email, password, city, sex;

    public User(String name, String phone, String email, String password, String city, String sex) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.city = city;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getSex() {
        return sex;
    }
}
