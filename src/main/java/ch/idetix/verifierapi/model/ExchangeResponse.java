package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeResponse {
    @JsonProperty("status")
    public Status status;

    @JsonProperty("data")
    private ExchangeData data;
}
