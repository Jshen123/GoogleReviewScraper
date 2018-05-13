package io.github.jshen123.googlereviewscraper;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){

        print("Enter csv file location: ");
        Scanner reader = new Scanner(System.in);

        ArrayList<String> urlList= new ArrayList<>();

        String fileName = reader.nextLine();
        File file = new File(fileName);

        try {
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNextLine()){
                urlList.add("https://www.google.com/search?q=" + inputStream.nextLine());
            }
            inputStream.close();

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        urlList.remove(0);

//        print("running...");

//        ArrayList<String> testArray = new ArrayList<>();
//        testArray.add("https://www.google.com/search?q=900+Arbour+Lake+Road+NW+senior");
//        testArray.add("https://www.google.com/search?q=Brooksdale+Broadway+Mesa+senior");

        GoogleReviewScraper scraper = new GoogleReviewScraper(urlList);
//
//        for (int i = 0; i < urlList.size(); i++){
//            print(scraper.getRating().get(i));
//            print(scraper.getNumberOfReviews().get(i));
//        }


        print("done!");
    }

    public static void print(String string) {
        System.out.println(string);
    }
}

