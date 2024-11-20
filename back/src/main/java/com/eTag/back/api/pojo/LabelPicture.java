package com.eTag.back.api.pojo;

import lombok.Data;

@Data
public class LabelPicture {

    private Integer X;

    private Integer Y;

    private Integer Width;

    private Integer Height;

    private String PictureUrl;

    private String PictureMD5;

    private String PictureName;
}
