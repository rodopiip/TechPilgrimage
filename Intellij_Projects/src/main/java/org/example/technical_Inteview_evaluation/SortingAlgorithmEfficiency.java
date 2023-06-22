package org.example.technical_Inteview_evaluation;

import java.util.Scanner;

public class SortingAlgorithmEfficiency {
    /*
    You have been tasked with evaluating the efficiency of different sorting algorithms in Java.
    You will be provided with an array of integers and your task is to apply different sorting algorithms,
    measure their execution time, and determine the most efficient one.

    Input: The first line consists of a positive integer, n, representing the size of the array.
    The next line consists of n space-separated integers, representing the array to be sorted.

    Output: Print the name of the most efficient sorting algorithm, based on execution time.

    Note: Evaluate at least three sorting algorithms: Bubble Sort, Quick Sort, and Merge Sort.
     */
    public static String [] sort1(int[]numbers){
        //time sorting time (and display it)
        //display name of sorting algorithm
        //todo: write code here
        //first element is the name of the sorting algorithm
        String algoName;
        //second is the speed, which is later turned into an integer
        int sortingSpeed;//later will be turned to a String
        // and back to an int when comparison time comes in
        //thw algorithmSortingSpeedMeter() method
        return null;
    }
    public static String [] sort2(int[]numbers){
        //time sorting time (and display it)
        //display name of sorting algorithm
        //todo: write code here
        return null;
    }
    public static String [] sort3(int[]numbers){
        //time sorting time (and display it)
        //display name of sorting algorithm
        //todo: write code here
        return null;
    }
    public static String [] sort4(int[]numbers){
        //time sorting time (and display it)
        //display name of sorting algorithm
        //todo: write code here
        return null;
    }
    public static void algorithmSortingSpeedMeter(String[]algo1, String[]algo2, String[]algo3, String[]algo4){
        /*
        compares sorting speed of 4 sorting algorithms
        for a particular collection of numbers
        displays the fastest one
        */
        //todo: write code here
    }
    public static void main(String[] args) {
        /*
        Input:
            5
            5 3 2 4 1
        Output:
            Quick Sort
         */
        Scanner scanner = new Scanner(System.in);
        int entry_size = scanner.nextInt();
        scanner.nextLine();
        int numbers [] = new int[entry_size];
        for (int number : numbers){
            number = scanner.nextInt();
        }
        String algo1 [] = sort1(numbers);
        String algo2 [] = sort2(numbers);
        String algo3 [] = sort3(numbers);
        String algo4 [] = sort4(numbers);
        algorithmSortingSpeedMeter(algo1, algo2, algo3, algo4);
    }
}
