package com.eTag.back.api.pojo;

import lombok.Data;

import java.util.List;

@Data
public class LabelVideo {

    private Integer X;

    private Integer Y;

    private Integer Width;

    private Integer Height;

    private List<Video> VideoList;
}
