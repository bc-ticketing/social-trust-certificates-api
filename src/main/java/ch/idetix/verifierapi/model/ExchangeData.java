package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeData {
    @JsonProperty("1027")
    private Token token;
}