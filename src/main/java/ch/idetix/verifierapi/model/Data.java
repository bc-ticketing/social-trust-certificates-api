package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("public_metrics")
    private PublicMetrics publicMetrics;
    @JsonProperty("username")
    private String username;
    @JsonProperty("url")
    private String url;
    @JsonProperty("protected")
    private Boolean _protected;
    @JsonProperty("location")
    private String location;
    @JsonProperty("id")
    private String id;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("name")
    private String name;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("pinned_tweet_id")
    private String pinnedTweetId;
}