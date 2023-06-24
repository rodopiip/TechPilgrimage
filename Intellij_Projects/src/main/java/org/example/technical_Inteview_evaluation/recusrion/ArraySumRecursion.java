package org.example.technical_Inteview_evaluation.recusrion;

public class ArraySumRecursion {
    /*
    note:
        >>>Identify the base case:
            Determine the condition that will terminate the recursion.
            It should be the equivalent condition that would exit the for loop
            in the iterative solution.
        >>>Define the recursive method:
            Create a method that will handle the recursive logic.
            It should take parameters equivalent to the variables used in the for loop.
        >>>Implement the base case:
            Check if the base case condition is met.
            If it is, return the desired result or perform any necessary actions.
        >>>Define the recursive case:
            In the else part of the base case check,
            mimic the logic performed in each iteration of the for loop.
            Typically, this involves calling the recursive method with modified parameters.
        >>>Modify variables and control flow:
            Adjust the variable values or control flow to mimic the changes
            that would occur in each iteration of the for loop.
            This may involve incrementing or decrementing variables
            or using indices to access different elements.
        >>>Recursive call:
            Within the recursive case, call the recursive method with the modified parameters.
            This will invoke the recursive logic until the base case is reached.
        >>>Handle the return value:
            If the iterative solution returns a value at the end of the loop,
            make sure to handle the return value appropriately in the recursive solution.
 */
    public static int iterativeSum(int[]array){
        int sum = 0;
        for (int i = 0; i<array.length; i++){
            sum+=array[i];
        }
        return sum;
    }
    public static int recursiveSum(int[]array){
        return recursiveSumHelper(array, 0);
    }
    private static int recursiveSumHelper(int[]array, int index){
        //Base case:
        if (index == array.length){
            return 0;
        }
        //Recursive case:
        return array[index]+recursiveSumHelper(array, index+1);
    }
    public static void main(String[] args) {
        int[]array = new int[]{1, 5, 7, 9};
        System.out.println("Iterative sum: "+ iterativeSum(array));
        System.out.println("Recursive sum: "+recursiveSum(array));
    }
}
