package ch.idetix.verifierapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExtractor {
    public String extractEthAddress(String string){
        Pattern pattern = Pattern.compile("0x[a-fA-F0-9]{40}");
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            return matcher.group();
        }

        return null;
    }
}
