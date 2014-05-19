/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.chain;

/**
 *
 * @author CIRO
 * @param <T>
 */
public class ChainNode <T>  {
    
    //Fields
    T element;
    ChainNode<T> next;
    
    //Constructors
    public ChainNode( ){
        this( null , null);
    }
    public ChainNode( T element ){
        this( element , null );
    }
    public ChainNode( T element , ChainNode<T> next  ){
        this.element = element;
        this.next = next;
    }
    
    //Getters

    /**
     * @return the element
     */
    public T getElement() {
        return element;
    }

    /**
     * @return the next
     */
    public ChainNode<T> getNext() {
        return next;
    }

    //Setters
    
    /**
     * @param element the element to set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * @param next the next to set
     */
    public void setNext(ChainNode<T> next) {
        this.next = next;
    }
    
    
}
