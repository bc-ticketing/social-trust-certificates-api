package ch.idetix.verifierapi.service;

import ch.idetix.verifierapi.model.ExchangeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
@Slf4j
public class ExchangeServiceImpl implements ExchangeService{
    @Value("${app.exchange.api.key}")
    private String apiKey;


    @Override
    public ExchangeResponse getEthChfTradingPair() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1027&convert=CHF")
                .method("GET", null)
                .addHeader("X-CMC_PRO_API_KEY", apiKey)
                .build();

        ResponseBody responseBody = null;
        try {
            responseBody = client.newCall(request).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.toString());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        ExchangeResponse exchangeResponse = null;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            exchangeResponse = objectMapper.readValue(responseBody.string(), ExchangeResponse.class);
        } catch (Exception e) {
            log.error(e.toString());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "error parsing the response");
        }

        return exchangeResponse;
    }
}
