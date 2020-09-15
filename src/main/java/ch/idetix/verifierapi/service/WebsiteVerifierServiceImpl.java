package ch.idetix.verifierapi.service;

import ch.idetix.verifierapi.model.WebsiteResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WebsiteVerifierServiceImpl implements WebsiteVerifierService{
    @Override
    public WebsiteResponse verifyWebsite(String url) {

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
        return websiteResponse;
    }
}
