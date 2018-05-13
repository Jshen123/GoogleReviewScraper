package io.github.jshen123.googlereviewscraper;

import java.io.*;
import java.util.Scanner;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){

        print("Enter csv file location: ");
        Scanner reader = new Scanner(System.in);

        ArrayList<String> urlList= new ArrayList<>();
        ArrayList<String> infoList= new ArrayList<>();

        String fileName = reader.nextLine();
        File file = new File(fileName);

        try {
            Scanner inputStream = new Scanner(file);
            while(inputStream.hasNextLine()){
                infoList.add(inputStream.nextLine());
            }
            inputStream.close();

        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

        infoList.remove(0);

        print("running...");

        // add google search url before query terms
        for (int i = 0; i < infoList.size(); i++){
            urlList.add("https://www.google.com/search?q=" + infoList.get(i));
        }

        GoogleReviewScraper scraper = new GoogleReviewScraper(urlList);

        try {
            FileOutputStream fout = new FileOutputStream("output_google_reviews_data.csv");
            PrintStream csv = new PrintStream(fout);
            csv.println("name                                       rating   number of reviews ");

            for (int i = 0; i < infoList.size(); i++){
                csv.println(infoList.get(i) + "  " + scraper.getRating().get(i) + "  " + scraper.getNumberOfReviews().get(i));
            }

            fout.close();

        } catch(IOException e){
            e.printStackTrace();
        }


        print("done!");
    }

    public static void print(String string) {
        System.out.println(string);
    }
}

