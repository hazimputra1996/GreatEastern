package com.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ClosestNumberToZero extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int[] listNumber = {1212,7,-1,3,-4,1,5,6,65,12,1212,12,10,12,1};
        System.out.println("The closet number to zero is : "+getClosestToZero(listNumber)); //For the second question

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

    public static void main(String[] args) {
        launch();
    }
}