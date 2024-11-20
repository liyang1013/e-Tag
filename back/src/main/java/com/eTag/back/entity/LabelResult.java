package com.eTag.back.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LabelResult {

    @JsonProperty("State")
    private String State;

    @JsonProperty("Message")
    private String Message;

    @JsonProperty("Number")
    private String Number;

    @JsonProperty("Data")
    private String Data;
}
