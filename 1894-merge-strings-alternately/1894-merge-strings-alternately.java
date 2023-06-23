class Solution {
    public String mergeAlternately(String word1, String word2) {
        //compare the two strings
        int length1 = word1.length();
        int length2 = word2.length();
        int length = length1;
        StringBuilder mergedString = new StringBuilder();
        //take the shorter one
        if (length1>length2){
            length=length2;
        }
        //iterate over it
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