package io.github.jshen123.googlereviewscraper;

public class Main {
    public static void main(String args[]){
        print("running...");

        GoogleReviewScraper scraper = new GoogleReviewScraper("www.google.com");
    }

    public static void print(String string) {
        System.out.println(string);
    }
}

