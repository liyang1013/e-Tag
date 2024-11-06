package com.keboda.eomsback.email.pojo;

import lombok.Data;

@Data
public class EmailBody {

    private String from;

    private String to;

    private String cc;

    private String subject;

    private String text;
}
