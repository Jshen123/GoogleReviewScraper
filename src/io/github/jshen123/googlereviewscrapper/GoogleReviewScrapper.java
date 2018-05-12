package io.github.jshen123.googlereviewscrapper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleReviewScrapper {
    private Document document;

    public GoogleReviewScrapper(String url){
        try{
            document = Jsoup.connect(url).get();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
