package ch.idetix.verifierapi.controller;

import ch.idetix.verifierapi.model.TwitterResponse;
import ch.idetix.verifierapi.model.WebsiteResponse;
import ch.idetix.verifierapi.service.TwitterVerifierService;
import ch.idetix.verifierapi.service.WebsiteVerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/")
@RestController
@Validated
public class VerifierController {

    @Autowired
    private WebsiteVerifierService websiteVerifierService;

    @Autowired
    private TwitterVerifierService twitterVerifierService;

    @CrossOrigin(origins = "/**")
    @RequestMapping(value = "/website", method = GET)
    public WebsiteResponse verifyWebsite(
//            @Pattern(regexp = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)", message = "url does not seem to be a valid url")
            @Pattern(regexp = "https?:\\/\\/.*")
            @RequestParam String url) {
        return websiteVerifierService.verifyWebsite(url);
    }

    @RequestMapping(value = "/twitter", method = GET)
    public TwitterResponse verifyTwitter(
            @NotBlank(message = "username is mandatory")
            @Size(min = 1, max = 15, message = "username must be between 1 and 15 characters")
            @RequestParam String username) {
        return twitterVerifierService.verifyUsername(username);
    }
}
