package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Token {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("symbol")
    public String symbol;
    @JsonProperty("slug")
    public String slug;
    @JsonProperty("num_market_pairs")
    public Integer numMarketPairs;
    @JsonProperty("date_added")
    public String dateAdded;
    @JsonProperty("tags")
    public List<String> tags = null;
    @JsonProperty("max_supply")
    public Object maxSupply;
    @JsonProperty("circulating_supply")
    public Double circulatingSupply;
    @JsonProperty("total_supply")
    public Double totalSupply;
    @JsonProperty("is_active")
    public Integer isActive;
    @JsonProperty("platform")
    public Object platform;
    @JsonProperty("cmc_rank")
    public Integer cmcRank;
    @JsonProperty("is_fiat")
    public Integer isFiat;
    @JsonProperty("last_updated")
    public String lastUpdated;
    @JsonProperty("quote")
    public Quote quote;

}
