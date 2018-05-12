package io.github.jshen123.googlereviewscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleReviewScraper {
    private Document document;

    public GoogleReviewScraper(String url){
        try{
            document = Jsoup.connect(url).get();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
