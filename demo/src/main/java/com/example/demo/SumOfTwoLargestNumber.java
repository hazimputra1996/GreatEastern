package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class SumOfTwoLargestNumber extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int[] listNumber = {1212,7,-1,3,-4,1,5,6,65,12,1212,12,10,12,1};
        System.out.println("The sum of two largest value is : "+sumOfTwoLargestElements((listNumber))); //For the first question

    }

    public static int sumOfTwoLargestElements(int[] a) {
        if (a == null || a.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements minimum"); // throw error if the a size smaller than 2
        }

        Integer largestNumber =Arrays.stream(a).max().getAsInt(); // find the largest number

        int count = 0;
        for (int value : a) {
            if (value == largestNumber) {
                count++;
            }
        } // count the largest number in the array

        if (count>1){
            return largestNumber+largestNumber;
        } // since largest is more than 1, basically, it is same number first and second largest

        else {

            Integer secondLargest =
                    Arrays.stream(a)
                            .filter(b -> b != largestNumber)
                            .max()
                            .getAsInt(); // get the second-highest by filter out the largest number

            return largestNumber + secondLargest;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}