package com.eTag.back.api.pojo;

import lombok.Data;

@Data
public class Label {

    private String ItemCode;

    private String Id;

    private String ItemName;

    private LabelPicture LabelPicture;

    private LabelVideo LabelVideo;

    private Integer Nlast;
}
