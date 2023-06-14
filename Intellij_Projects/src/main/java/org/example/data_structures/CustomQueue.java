package org.example.data_structures;

public class CustomQueue {
    private CustomStack customEnqueueStack;
    private CustomStack customDequeueStack;
    public CustomQueue(){
        this.customEnqueueStack = new CustomStack();
        this.customDequeueStack = new CustomStack();
    }
    public void enqueue(Object object){
        this.customEnqueueStack.push(object);
    }
    public Object dequeue(){
        if (this.customDequeueStack.isEmpty()){
            if (this.customEnqueueStack.isEmpty()){
                //question: is RuntimeException suitable?
                throw new IllegalStateException("Queue is empty");
            } else {
                //for each element form enqueue, take it and put it in the dequeue
                while (!this.customEnqueueStack.isEmpty()){
                    //question: how do I return the top object? Do I even need to do it?
                    this.customDequeueStack.push(this.customEnqueueStack.pop());
                }
            }
        }
        return customDequeueStack.pop();
    }
}
