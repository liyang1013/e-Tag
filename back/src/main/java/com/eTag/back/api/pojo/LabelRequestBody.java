package com.eTag.back.api.pojo;

import lombok.Data;

@Data
public class LabelRequestBody {

    private  String appid;

    private String clientid;

    private Integer nlast;

    private Long ts;

    private String sign;

    private String deviceno;

    private String type;

    //适用于5.X以下固件
    public String getStringSignTemp(){
        return "appid="+this.appid+"&clientid="+this.clientid+"&nlast="+this.nlast+"&ts=" + this.ts + "&key=";
    }
    //适用于5.X以上固件
    public String getStringSign5X(){
        return "appid="+this.appid+"&deviceno="+this.deviceno+"&type="+this.type+ "&key=";

    }
}
