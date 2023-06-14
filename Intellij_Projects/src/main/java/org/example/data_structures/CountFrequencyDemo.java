package org.example.data_structures;

import java.util.Arrays;
import java.util.List;

public class CountFrequencyDemo {
    public static void main(String[] args) {
        CustomMap<String, Integer> map = new CustomMap<>();
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana", "grape", "apple");
        map.countFrequency(words);
        for (String key : map.getKeySet()){
            System.out.println(key + ": " + map.get(key));
        }
    }
}
