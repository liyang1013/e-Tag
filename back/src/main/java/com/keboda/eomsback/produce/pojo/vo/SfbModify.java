package com.keboda.eomsback.produce.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.keboda.eomsback.produce.pojo.SfbFile;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class SfbModify {

    private String centre;


    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ddate;

    private Boolean flag;

    private List<SfbFile> sfbArr;
}
