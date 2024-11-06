package com.keboda.eomsback.stock.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IMG_FILE
 * @author 
 */
@Data
public class ImgFileKey implements Serializable {
    private String img01;

    private String img02;

    private String img03;

    private String img04;

    private static final long serialVersionUID = 1L;
}