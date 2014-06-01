/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.queue;

import co.edu.unal.ds.chain.ChainNode;


/**
 *
 * @author CIRO
 * @param <T>
 */
public class LinkedQueue <T> implements Queue<T> {

    //Fields
    protected ChainNode<T> front;
    protected ChainNode<T> rear;
    
    //Constructors
    
    /**Create an empty Queue*/
    public LinkedQueue( ){
        front = rear = null;
    }
    
    //Methods
    
    /** @return true if Queue is empty*/
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    /** @return the element at the front of the Queue
     *  @return null if the Queue is empty
     */
    @Override
    public T getFrontElement() {
        return isEmpty( ) ? null : front.element;
    }

    /** @return the element at the rear of the Queue
     *  @return null if the Queue is empty
     */
    @Override
    public T getRearElement() {
        return isEmpty( ) ? null : rear.element;
    }

    /** insert theObject at the end of the Queue
     * @param theObject*/
    @Override
    public void put(T theObject) {
        ChainNode<T> p = new ChainNode( theObject , null );
        
        if( front == null ) {
            //Empty Queue
            front = p;
        }
        else {
            //non-Empty Queue
            rear.next = p;
        }
        
        //Updating rear reference
        rear = p;
    }
    
    /** remove the element at the front of the Queue
     *  @return the removed element
     *  @return null if the Queue is empty
     */
    @Override
    public T remove() {
        if( isEmpty( ) ){
            return null;
        }
        T frontElement = front.element;
        front = front.next;
        if( isEmpty( ) ){
            //enable garbage collection
            rear = null;
        }
        
        return frontElement;
    }
    
}
