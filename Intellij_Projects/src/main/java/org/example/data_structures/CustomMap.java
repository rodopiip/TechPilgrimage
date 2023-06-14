package org.example.data_structures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomMap<K, V> {
    private Map<K, V> map;
    public CustomMap(){
        this.map = new HashMap<>();
    }
    public Object get(K key){
        return this.map.get(key);
    }
    public Object remove(Object key){
        return this.map.remove(key);
    }
    public void put(K key, V value){
        this.map.put(key, value);
    }
    //question: is this a getter method?
    public Set<K> getKeySet(){
        return this.map.keySet();
    }
    public void countFrequency(List<String> words){
        for(String word : words){
            if (this.map.containsKey(word)){
                Integer frequency = (Integer) this.map.get(word);
                //question: why doesn't the Integer wrapper class compile?
                this.map.put((K) word, (V) (Integer) (frequency+1));
            } else {
                //question: why doesn't the Integer wrapper class compile?
                this.map.put((K) word, (V) (Integer) 1);
            }
        }
    }
}
