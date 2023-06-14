package org.example.data_structures;

import java.lang.RuntimeException;
import java.util.Arrays;

public class CustomStack {
    private Object[] stackArray;
    private int top;
    public CustomStack(){
        //create an empty stack with 0 elements
        stackArray = new Object[0];
        top = -1;
    }
    public CustomStack(int size){
        stackArray = new Object[size];
        top = -1;
    }
    //create a nested StackOverflowException class
    public class StackOverflowException extends RuntimeException{
        public StackOverflowException(String message){
            super(message);
        }
    }
    //create a nested StackUnderflowException class
    public class StackUnderflowException extends RuntimeException{
        public StackUnderflowException(String message){
            super(message);
        }
    }
    public void push(Object value){
        if (isFull()){
            int newSize = 2 * stackArray.length;
            System.out.print("size increased from "+stackArray.length);
            stackArray = Arrays.copyOf(stackArray, newSize);
            System.out.println(" to "+stackArray.length);
        }
        stackArray[++top]=value;
    }
    public Object pop(){
        if (isEmpty()){
            throw new StackUnderflowException("Stack is empty. Can't pop value.");
        }
        Object popped = stackArray[top];
        stackArray[top--] = null;//dereference for garbage collector
        return popped;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top == stackArray.length-1;
    }
    //todo handle stack overflow
    //todo handle stack underflow
    public int size(){
        return stackArray.length;
    }
    //generate a method similar to size(), which returns all elements that are not null
    public int sizeNotNull(){
        int count = 0;
        for (int i = 0; i<stackArray.length; i++){
            if (stackArray[i] != null){
                count++;
            }
        }
        return count;
    }

}
