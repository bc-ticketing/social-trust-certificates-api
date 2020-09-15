package ch.idetix.verifierapi.service;

import ch.idetix.verifierapi.model.TwitterResponse;

public interface TwitterVerifierService {
    TwitterResponse verifyUsername(String username);
}
