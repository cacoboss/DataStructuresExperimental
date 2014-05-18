/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package queue;

import interfaces.*;
        
/**
 *
 * @author CIRO
 */
public class ArrayQueue <T> implements Queue <T> {

    //Fields
    protected int front;
    protected int rear;
    protected T[] queue;
    
    //Constructors
    public ArrayQueue(int initialCapacity){
        if(initialCapacity < 1){
            throw new IllegalArgumentException("The size of the queue is to short");
        }
        queue = ( T[] ) new Object[initialCapacity + 1];
        front = rear = 0;
    }
    
    public ArrayQueue(){
        this(10);
    }
    
    
    //Methods
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public T getFrontElement() {
        if( isEmpty( ) ){
            return null;
        }
        else{
            return queue[(front + 1) % queue.length ];
        }
    }

    @Override
    public T getRearElement() {
        if( isEmpty( ) ){
            return null;
        }
        else{
            return queue[ rear ];
        }
    }

    @Override
    public void put(T theObject) {
        if( (rear + 1 ) % queue.length == front ){
            //double the array size
            //allocate a new array
            T[] newQueue = ( T[] ) new Object[ 2 * queue.length ];
            
            //copy all the elements into the new array
            int start = ( front + 1 ) % queue.length;
            if( start < 2 ){
                //no wrap around
                System.arraycopy(queue, start, newQueue, 0, queue.length - 1);
            }
            else{
                //wrap around
                System.arraycopy(queue, start, newQueue, 0, queue.length - start);
                System.arraycopy( queue, 0, queue, queue.length - start, rear + 1 );
            }
            
            // switch to newQueue and set front and rear
            front = newQueue.length - 1;
            rear = queue.length - 2; // queue size is queue.length - 1
            queue = newQueue;
        }
        // put theElement at the rear of the queue
        rear = ( rear + 1 ) % queue.length;
        queue[ rear ] = theObject;
    }

    @Override
    public T remove() {
        if( isEmpty( ) ){
            return null;
        }
        front = (front + 1) % queue.length;
        T frontElement = queue[ front ];
        queue[ front ] = null;  // enable garbage collection
        return frontElement;
    }
    
}
