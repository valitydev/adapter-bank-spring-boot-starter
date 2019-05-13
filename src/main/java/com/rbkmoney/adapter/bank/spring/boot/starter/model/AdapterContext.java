package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;


@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdapterContext {

    @JsonProperty(value = "max_date_time_polling")
    private Instant maxDateTimePolling;
    private Step nextStep;
    private String pares;
    @JsonProperty(value = "trx_id")
    private String trxId;

}