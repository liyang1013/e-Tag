package com.keboda.eomsback.plc.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hoist {

    private Integer id;

    private String plcitem;

    private Short floor;

    private Integer taskno;
}
