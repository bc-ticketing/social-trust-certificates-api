package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CHF {

    @JsonProperty("price")
    public Double price;
    @JsonProperty("volume_24h")
    public Double volume24h;
    @JsonProperty("percent_change_1h")
    public Double percentChange1h;
    @JsonProperty("percent_change_24h")
    public Double percentChange24h;
    @JsonProperty("percent_change_7d")
    public Double percentChange7d;
    @JsonProperty("market_cap")
    public Double marketCap;
    @JsonProperty("last_updated")
    public String lastUpdated;

}
