package ch.idetix.verifierapi.controller;


import ch.idetix.verifierapi.model.ExchangeResponse;
import ch.idetix.verifierapi.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping("/api/exchange")
@RestController
@Validated
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @RequestMapping(value = "/eth-chf", method = GET)
    public ExchangeResponse verifyTwitter() {
        return exchangeService.getEthChfTradingPair();
    }

}
