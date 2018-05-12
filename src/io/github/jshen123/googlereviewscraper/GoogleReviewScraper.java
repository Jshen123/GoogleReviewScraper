package io.github.jshen123.googlereviewscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleReviewScraper {
    private Elements rating;
    private Elements numberOfReviews;
    private Document document;

    public GoogleReviewScraper(String url){
        try{
            // get Document object after parsing the html from given url
            document = Jsoup.connect(url).get();
            // get rating from the specified url
            rating = document.select("span.rtng");
            // get number of reviews from the specified url
            numberOfReviews = document.select("span:containsOwn( Google reviews)");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Document getDocument() {
        return document;
    }

    public Elements getRating() {
        return rating;
    }

    public Elements getNumberOfReviews() {
        return numberOfReviews;
    }

}
