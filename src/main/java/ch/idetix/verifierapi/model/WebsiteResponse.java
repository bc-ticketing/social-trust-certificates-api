package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WebsiteResponse {
    @JsonProperty("eth_address")
    private String ethAddress;

    @JsonProperty("ens")
    private String ens;
}
