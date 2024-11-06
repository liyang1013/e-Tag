package com.keboda.eomsback.produce.pojo.vo;

import com.keboda.eomsback.produce.pojo.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SfbStatusVo {

    private SfbFile sfb;

    private List<SfpFile> sfp;

    private List<ShbFile> shb;

    private List<QcfFile> qcf;

    private List<SfuFile> sfu;
}
