package org.example.technical_Inteview_evaluation.recusrion;

public class FactorialRecursion {
    public static int iterativeFactorial(int number){
        int result = 1;
        for (int i = 1; i<=number; i++){
            result*=i;
        }
        return result;
    }
    public static int recursiveFactorial(int number){
        //Base case:
        if (number == 0 || number == 1){
            return 1;
        }
        //Recursive case:
        return number*recursiveFactorial(number-1);
    }
    public static void main(String[] args) {
        int number = 5;
        System.out.println("Recursively defined factorial of "+number+" is: "+ recursiveFactorial(number));
        System.out.println("Iteratively defined factorial of "+number+" is: "+ iterativeFactorial(number));
    }
}
