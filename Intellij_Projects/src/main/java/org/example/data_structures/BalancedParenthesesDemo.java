package org.example.data_structures;

public class BalancedParenthesesDemo {
    public static void main(String[] args) {
        /*
        note:
         write a function that takes a string of parentheses
         and checks if it is balanced using your custom Stack class.
         */
        //memo 1: Create an empty stack using your CustomStack class.
        CustomStack stack = new CustomStack(2);
        //create a string of parentheses
//        String parentheses = "((()))";
//        String parentheses = "(()))";
//        String parentheses = "(()()";
//        String parentheses = "(()())";
//        String parentheses = "((()()";
        //generate a parenthesis string which induces more than the not null size of the stack to be greater that 3
        String parentheses = "((((((((((()()))))))";
        //memo 2: Loop through each character in the string.
        for (int i = 0; i<parentheses.length(); i++){
            char current = parentheses.charAt(i);
            if (current == '('){
                stack.push(current);
                System.out.println("Iteration : "+i+" : stack size : "+stack.sizeNotNull());
            }else if (current == ')'){
                if (stack.isEmpty()){
                    System.out.println("Unbalanced parentheses");
                    return;
                } else {
                    stack.pop();
                }

            }
        }
        if (!stack.isEmpty()){
            System.out.println("Unbalanced parentheses");
        } else {
            System.out.println("Balanced parentheses");
        }
    }
}
