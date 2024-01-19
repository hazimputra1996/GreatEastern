package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int[] listNumber = {1212,7,-1,3,-4,1,5,6,65,12,1212,12,10,12,1};
        System.out.println("The sum of two largest value is : "+sumOfTwoLargestElements((listNumber))); //For the first question
        System.out.println("The closet number to zero is : "+getClosestToZero(listNumber)); //For the second question
        System.out.println("The List of the natural numbers: \n" + naturalNumber235(1500)); ////For the third question

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

    public static int getClosestToZero(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must have at least one element"); // put error if a is null
        }

        int minValue = Integer.MAX_VALUE; //initiate minValue
        int minDifference = Integer.MAX_VALUE; //initiate minDifferent

        for (int number : a) {
            int differenceToZero = Math.abs(number); // found absolute different number with zero

            //Update the new value of minDifference and minValue for case smaller number OR same number but the number is positive
            if (differenceToZero < minDifference || (differenceToZero == minDifference && number > minValue)) {
                minDifference = differenceToZero;
                minValue = number;
            }
        }
        return minValue;
    }

    public static String naturalNumber235(Integer total) {
        int count = total+1;
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1); // Start with 1 to include 3 and 5

        int i2 = 0, i3 = 0, i5 = 0;
        while (numbers.size() < count) {
            int next2 = numbers.get(i2) * 2;
            int next3 = numbers.get(i3) * 3;
            int next5 = numbers.get(i5) * 5;

            int smallest = Math.min(next2, Math.min(next3, next5));
            numbers.add(smallest);

            if (smallest == next2) i2++;
            if (smallest == next3) i3++;
            if (smallest == next5) i5++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            result.append(i).append(" : ").append(num).append(" : [");

            int originalNum = num;

            boolean hasFactors = false; // Flag to check if there are factors other than 1
            while (num % 2 == 0) {
                result.append("2 ");
                num /= 2;
                hasFactors = true;
            }
            while (num % 3 == 0) {
                result.append("3 ");
                num /= 3;
                hasFactors = true;
            }
            while (num % 5 == 0) {
                result.append("5 ");
                num /= 5;
                hasFactors = true;
            }

            // If there's only one prime factor, append it
            if (!hasFactors) {
                result.append(originalNum);
            }

            // Trim the trailing space if present
            result.setLength(result.length() - 1);

            result.append("]\n");
        }

        int firstNewlineIndex = result.indexOf("\n");
        if (firstNewlineIndex != -1) {
            result.delete(0, firstNewlineIndex + 1); // remove the first line which include the 1
        }

        return result.toString();
    }




    public static void main(String[] args) {
        launch();
    }
}