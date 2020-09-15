package ch.idetix.verifierapi.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringExtractorTest {

    @Test
    public void testEthAddressExtraction(){
        StringExtractor stringExtractor = new StringExtractor();
        String ethAddress = "0x52908400098527886E0F7030069857D2E4169EE7";
        String someString = "someChars1234" + ethAddress + "someMore1234";
        String extractedAddress = stringExtractor.extractEthAddress(someString);
        Assertions.assertEquals(ethAddress, extractedAddress);
    }
}