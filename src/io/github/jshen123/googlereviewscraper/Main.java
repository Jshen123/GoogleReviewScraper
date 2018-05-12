package io.github.jshen123.googlereviewscraper;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        print("running...");

        ArrayList<String> testArray = new ArrayList<>();
        testArray.add("https://www.google.com/search?q=900+Arbour+Lake+Road+NW+senior");
        testArray.add("https://www.google.com/search?q=Brooksdale+Broadway+Mesa+senior");

        GoogleReviewScraper scraper = new GoogleReviewScraper(testArray);

//        for (int i = 0; i < testArray.size(); i++){
//            print(scraper.getRating().get(i));
//            print(scraper.getNumberOfReviews().get(i));
//        }


        print("done!");
    }

    public static void print(String string) {
        System.out.println(string);
    }
}

