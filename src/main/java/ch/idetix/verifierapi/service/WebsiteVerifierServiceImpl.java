package ch.idetix.verifierapi.service;

import ch.idetix.verifierapi.model.WebsiteResponse;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class WebsiteVerifierServiceImpl implements WebsiteVerifierService{
    @Override
    public WebsiteResponse verifyWebsite(String url) {
        log.info("verifying website: {}", url);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            System.out.println("message " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        Elements metaTags = doc.getElementsByTag("meta");
        WebsiteResponse websiteResponse = new WebsiteResponse();

        for (Element metaTag : metaTags) {
            String content = metaTag.attr("content");
            String name = metaTag.attr("name");

            if("idetix".equals(name)) {
                websiteResponse.setEthAddress(content);
            }
        }

        log.info("found ETH address for twitter profile of {} with {}", url, websiteResponse.getEthAddress());

        return websiteResponse;
    }
}
