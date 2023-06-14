package org.example.data_structures;

public class ArrayRotationDemo {
    public static void main(String[] args) {
        /*
        note:
         Given an array of integers and a number 'n',
         write a function that rotates the array 'n' times.
         The rotation should be in place and to the right.
         */
        int[] array = {1, 2, 3, 4, 5};
        int n = 2;
        rotateArray(array, n);
    }

    private static void rotateArray(int[] array, int rotations){
        //initialize a new array named 'rotatedArray' with the same length as the input array
        int[] rotatedArray = new int[array.length];
        for (int i = 0; i<array.length; i++){
           rotatedArray[(i+rotations)%array.length] = array[i];
        }
        for (int i : rotatedArray){
            System.out.print(": "+i+" ");
        }
    }
}
