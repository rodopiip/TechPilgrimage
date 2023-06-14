package org.example.palindrome;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String word = "jkjl";
        boolean isPalindrome = true;
        //note: PALINDROME VER. 1
        for (int i = 0 ;i<word.length(); i++){
            if (!(word.charAt(i)==word.charAt(word.length()-i-1))){
                isPalindrome = false;
                break;
            }
        }
//        revealPalindrome(word, isPalindrome);
        isPalindrome = true;//variable reset
        //note: PALINDROME VER. 2
        //create a stack collection for half of the string
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<word.length()/2; i++){
            stack.push(word.charAt(i));
        }
        //iterate through the second half of the string and compare with the stack
        for(int i = word.length()/2; i<word.length(); i++){
            if (word.charAt(i)!=stack.pop()){
                isPalindrome = false;
                break;
            }
        }
//        revealPalindrome(word, isPalindrome);
        //note: PALINDROME VER. 3
        isPalindrome = true;//variable reset
        String reversedWord = new StringBuilder(word).reverse().toString();
        if (!word.equals(reversedWord)){
            isPalindrome=false;
        }
        revealPalindrome(word, isPalindrome);
        //note: PALINDROME VER. 4
        isPalindrome = isPalindromeRecursive(word, 0, word.length()-1);
//        revealPalindrome(word, isPalindrome);
        //note: PALINDROME VER. 5
        isPalindrome = true;//variable reset
        Deque<Character>dequeuedWord=new LinkedList<>();
        for (int i=0; i<word.length(); i++){
            dequeuedWord.addLast(word.charAt(i));
        }
        int iterations = word.length()/2;
        for (int i=0; i<iterations; i++){
            if (dequeuedWord.pollFirst()!=dequeuedWord.pollLast()){
                isPalindrome=false;
                break;
            }
        }
//        revealPalindrome(word, isPalindrome);
    }
    static void revealPalindrome(String palindrome, boolean isPalindrome){
        System.out.println(isPalindrome ? (palindrome+" is a palindrome") : (palindrome+" is NOT a palindrome"));
    }
    static boolean isPalindromeRecursive(String word, int left, int right){
        if (left >= right){
            return true;
        }
        if (word.charAt(left)!=word.charAt(right)){
            return false;
        } else {
            return isPalindromeRecursive(word, ++left, --right);
        }
    }
}
