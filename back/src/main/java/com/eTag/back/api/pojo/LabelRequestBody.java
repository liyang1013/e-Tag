package com.eTag.back.api.pojo;

import lombok.Data;

@Data
public class LabelRequestBody {

    private  String appid;

    private String clientid;

    private Integer nlast;

    private Long ts;

    private String sign;

    public String getStringSignTemp(){
        return "appid="+this.appid+"&clientid="+this.clientid+"&nlast="+this.nlast+"&ts=" + this.ts + "&key=";
    }
}
