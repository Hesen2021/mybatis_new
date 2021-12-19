package com.atcsc.Pojo;

//好家伙，原来已经注解过了

import lombok.Data;

@Data
public class User {
    private  int id;
    private String name;
    private String pwd;

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public User() {
    }
}
