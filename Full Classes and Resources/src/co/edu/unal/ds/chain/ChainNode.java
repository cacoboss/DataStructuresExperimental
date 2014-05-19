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
    public T element;
    public ChainNode<T> next;
    
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
    
}
