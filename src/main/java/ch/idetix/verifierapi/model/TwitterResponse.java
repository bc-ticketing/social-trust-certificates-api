package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
public class TwitterResponse {
    @JsonProperty("data")
    private Data data;

    @JsonProperty("eth_address")
    private String ethAddress;

    @JsonProperty("ens")
    private String ens;
}