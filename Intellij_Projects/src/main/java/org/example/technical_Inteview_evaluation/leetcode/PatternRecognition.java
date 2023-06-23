package org.example.technical_Inteview_evaluation.leetcode;

public class PatternRecognition {
    /*
    Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
     */
    public boolean wordPattern(String pattern, String s) {
        //split the pattern String
        String [] patternBreakdown = pattern.split("");
        //split the s String
        String [] strings = s.split(" ");
        //check if the two arrays have equal length
        if (patternBreakdown.length==strings.length){
            //if yes, continue with evaluation:
            //simultaneously compare array elements from both arrays
            //with other elements from each array
            for (int i = 0; i<patternBreakdown.length; i++){
                for (int j = 0; j<patternBreakdown.length; j++){
                    if (i!=j){
                        boolean patternBool = patternBreakdown[i].equals(patternBreakdown[j]);
                        boolean stringBool = strings[i].equals(strings[j]);
                        if (patternBool!=stringBool){
                            return false;
                        }
                    }
                }
            }
        } else {
            //otherwise there's no basis on which to compare patterns
            return false;
        }
        return true;
    }
}
