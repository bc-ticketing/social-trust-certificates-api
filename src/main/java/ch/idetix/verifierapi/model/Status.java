package ch.idetix.verifierapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {

    @JsonProperty("timestamp")
    public String timestamp;
    @JsonProperty("error_code")
    public Integer errorCode;
    @JsonProperty("error_message")
    public Object errorMessage;
    @JsonProperty("elapsed")
    public Integer elapsed;
    @JsonProperty("credit_count")
    public Integer creditCount;
    @JsonProperty("notice")
    public Object notice;

}
