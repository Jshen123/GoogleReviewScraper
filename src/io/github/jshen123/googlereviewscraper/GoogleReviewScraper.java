package io.github.jshen123.googlereviewscraper;

import java.io.IOException;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GoogleReviewScraper {
    private ArrayList<Document> document = new ArrayList<>();
    private ArrayList<String> rating = new ArrayList<>();
    private ArrayList<String> numberOfReviews = new ArrayList<>();

    public GoogleReviewScraper(ArrayList<String> urlList){
        try{
            for (int i = 0; i < urlList.size(); i++){
                // get Document object after parsing the html from given url
                document.add(Jsoup.connect(urlList.get(i)).get());
                // get rating from the specified url and convert the rating from element to string
                rating.add(document.get(i).select("span.rtng").text());
                // get nnumber of reviews from the specified url and convert the rating from element to string
                numberOfReviews.add(convertElementsToString(document.get(i).select("span:containsOwn( Google reviews)")));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public String convertElementsToString (Elements element){
        String string = element.text();
        String split[] = string.split(" ", 2);
        return split[0];

    }

    public ArrayList<String> getRating() {
        return rating;
    }

    public ArrayList<String> getNumberOfReviews() {
        return numberOfReviews;
    }
}
