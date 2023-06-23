package org.example.technical_Inteview_evaluation.leetcode;

public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        //initialize the merge string
        StringBuilder mergedString = new StringBuilder();
        //compare the two strings
        int length1 = word1.length();
        int length2 = word2.length();
        //take the shorter string's length
        int length = Math.min(length1, length2);
        //iterate over the 2 strings, by using the minimal length
        for (int i = 0; i<length;i++){
            //append the i characters of both strings
            mergedString.append(word1.charAt(i));
            mergedString.append(word2.charAt(i));
        }
        //finally append the longer part
        if (length1>length2){
            mergedString.append(word1.substring(length));
        } else if (length1<length2) {
            mergedString.append(word2.substring(length));
        }
        return mergedString.toString();
    }
}
