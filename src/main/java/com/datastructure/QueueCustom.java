package com.datastructure;

import java.lang.reflect.Array;

class MyQueue<T> {
	int front, rear, size; 
    int  capacity; 
    T array[]; 
       
    public MyQueue(Class<T> clazz, int capacity) { 
         this.capacity = capacity; 
         front = this.size = 0;  
         rear = capacity - 1; 
         array = (T[])Array.newInstance(clazz, capacity);      
    } 
       
    boolean isFull(MyQueue<T> queue) 
    {  return (queue.size == queue.capacity); 
    } 
       
    boolean isEmpty(MyQueue queue) 
    {  return (queue.array.length == 0); } 

    void enqueue(T item) 
    { 
        if (isFull(this)) 
            return; 
        this.rear = (this.rear + 1)%this.capacity; 
        this.array[this.rear] = item; 
        this.size = this.size + 1; 
        System.out.println(item+ " enqueued to queue"); 
    } 
       
    T dequeue() 
    { 
        if (isEmpty(this)) 
            return null; 
           
        T item = this.array[this.front]; 
        this.front = (this.front + 1)%this.capacity; 
        this.size = this.size - 1; 
        return item; 
    } 
       
    T front() 
    { 
        if (isEmpty(this)) 
            return null; 
           
        return this.array[this.front]; 
    } 
        
    T rear() 
    { 
        if (isEmpty(this)) 
            return null; 
           
        return this.array[this.rear]; 
    } 
} 
   
    
// Driver class 
public class QueueCustom 
{ 
    public static void main(String[] args)  
    { 
    	MyQueue<Integer> queue = new MyQueue<Integer>(Integer.class, 1000); 
            
        queue.enqueue(10); 
        queue.enqueue(20); 
        queue.enqueue(30); 
        queue.enqueue(40); 
        
        System.out.println(queue.dequeue() +  
                     " dequeued from queue\n"); 
        
        System.out.println("Front item is " +  
                               queue.front()); 
           
        System.out.println("Rear item is " +  
                                queue.rear()); 
    } 
}
