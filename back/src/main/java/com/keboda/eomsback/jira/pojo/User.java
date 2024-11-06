package com.keboda.eomsback.jira.pojo;

import lombok.Data;

@Data
public class User {

    private String name;

    private String password;

    private String pkcs5;

    private String email;
}
