package ch.idetix.verifierapi.service;

import ch.idetix.verifierapi.model.TwitterResponse;
import ch.idetix.verifierapi.utils.StringExtractor;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class TwitterVerifierServiceImpl implements TwitterVerifierService {
    @Value("${app.twitter.bearer}")
    private String bearerToken;

    @Override
    public TwitterResponse verifyUsername(String username) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.twitter.com/2/users/by/username/"+ username +"?user.fields=created_at,description,id,location,name,pinned_tweet_id,profile_image_url,protected,public_metrics,url,username,verified,withheld&=")
                .method("GET", null)
                .addHeader("Authorization", bearerToken)
                .build();

        ResponseBody responseBody = null;
        try {
            responseBody = client.newCall(request).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        TwitterResponse twitterResponse = null;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            twitterResponse = objectMapper.readValue(responseBody.string(), TwitterResponse.class);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username does not exist");
        }

        StringExtractor stringExtractor = new StringExtractor();
        twitterResponse.setEthAddress(stringExtractor.extractEthAddress(twitterResponse.getData().getDescription()));

        return twitterResponse;
    }
}
