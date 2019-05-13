package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Callback {
    @JsonProperty(value = "MD")
    private String md;
    @JsonProperty(value = "PaRes")
    private String paRes;
    @JsonProperty(value = "termination_uri")
    private String terminationUri;
}