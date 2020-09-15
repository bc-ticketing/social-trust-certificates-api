package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PublicMetrics {

    @JsonProperty("followers_count")
    private Integer followersCount;
    @JsonProperty("following_count")
    private Integer followingCount;
    @JsonProperty("tweet_count")
    private Integer tweetCount;
    @JsonProperty("listed_count")
    private Integer listedCount;
}