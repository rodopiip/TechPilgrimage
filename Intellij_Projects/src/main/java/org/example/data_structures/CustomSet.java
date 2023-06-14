package org.example.data_structures;

import java.util.HashMap;
import java.util.Map;

public class CustomSet {
    private Map<Object, Boolean> elements;
    public CustomSet (){
        this.elements = new HashMap<>();
    }

    public Map<Object, Boolean> getElements() {
        return elements;
    }

    public void add(Object object){
        //question: why do I need to make a map?
        // What is the benefit of having a a boolean object value?
        this.elements.put(object, true);
    }
    public boolean remove(Object object){
        return this.elements.remove(object);
    }
    public boolean contains(Object object){
        return this.elements.containsKey(object);
    }
    public int size(){
        return this.elements.size();
    }
    public CustomSet intersect(CustomSet set1, CustomSet set2){
        CustomSet intersectingSet = new CustomSet();
        for(Object object : set1.getElements().keySet()){
            if (set2.contains(object)){
                intersectingSet.add(object);
            }
        }
        return intersectingSet;
    }
}
