package org.example.algorith_complexity;

public class Demo {
    public static void main(String[] args) {
        /*
        note:
         Algorithm complexity and Big O notation help measure
         the performance of an algorithm by analyzing
         the relationship between the size of the input
         and the number of basic operations the algorithm takes.
         The complexity is expressed using the Big O notation:
         O(f(n)), where 'n' represents the input size and 'f(n)'
         represents the number of operations.
         */
        int[] arr = {8, 3, 14, 1, 5, 22, 9, 12};
        int largest = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i]>largest){
                largest = arr[i];
            }
        }
//        System.out.println(largest);
        int number = 5;
        int result = 1;
        for (int i = 1; i<=number; i++){
            result*=i;
        }
//        System.out.println(result);
        int[] arr2 = {4, 7, 12, 3, 9, 6, 1, 15};
        int sum = 0;
        for (int i = 0; i<arr2.length; i++){
            sum+=arr2[i];
        }
//        System.out.println(sum);
        int inspectedNumber = 53;
        boolean isPrime = inspectedNumber >= 2;
        for (int i = 2; isPrime && i<=Math.sqrt(inspectedNumber); i++){
            isPrime = (inspectedNumber%i != 0);
        }
//        System.out.println(inspectedNumber + " is " + ((isPrime) ? "" : "not ") + "a prime number");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int matrixSum = 0;
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                matrixSum+=matrix[i][j];
            }
        }
//        System.out.println(matrixSum);
        int sum2 = 0;
        for(int i = 1; i<=24; i++){
            sum2+=i;
        }
//        System.out.println(sum2);
        int sum3 = 0;
        int[] arr3 = {4, 2, 10, 8, 15, 23, 7, 6, 1, 3};
        for(int i = 0; i<arr3.length; i++){
            sum3+=arr3[i];
        }
//        System.out.println(sum3);

    }
}
