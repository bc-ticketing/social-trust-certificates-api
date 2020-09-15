package ch.idetix.verifierapi.service;

import ch.idetix.verifierapi.model.WebsiteResponse;

public interface WebsiteVerifierService {
    WebsiteResponse verifyWebsite(String url);
}
