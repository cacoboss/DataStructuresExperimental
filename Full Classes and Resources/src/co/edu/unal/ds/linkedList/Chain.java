/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.linkedList;

import co.edu.unal.ds.chain.ChainNode;
import co.edu.unal.ds.interfaces.LinearList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author CIRO
 * @param <T>
 */
public class Chain<T> implements LinearList<T>, Iterable<T> {
    
    //Fields
    protected ChainNode<T> firstNode;
    protected int size;
    
    //Constructor
    public Chain( ){
        firstNode = null;
        size = 0;
    }
    
    //Methods
    
    /** @throws IndexOutOfBoundsException when
     *index is not between 0 and size - 1 */
    private void checkIndex(int index) {
        if( index < 0 || index >= size ){
            throw new IndexOutOfBoundsException(
                    "index = " + index + "  size = " + size );
        }
    }

    /** @return true if list is empty*/
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** @return current number of elements in list*/
    @Override
    public int size() {
        return size;
    }

    /**
     * @param index
     * @return element with specified index
     * @throws IndexOtuOfBoundsException when
     * index is not between 0 and size - 1*/
    @Override
    public T get(int index) {
        
        checkIndex( index );
        
        //Move to the desired Node
        ChainNode<T> currentNode = firstNode;
        for( int i = 0; i < index; i++ ){
            currentNode = currentNode.next;
        }
        
        return currentNode.element;
    }

    /**
     * @param theElement
     * @return index of the first occurence of theElement
     * return -1 if theElement is not in the list*/
    @Override
    public int indexOf(T theElement) {
        //Search the chain for theElement
        ChainNode<T> currentNode = firstNode;
        int index = 0; //index of currentNode
        while( currentNode != null &&
                !currentNode.element.equals( theElement ) )
        {
            //Move to the next node
            currentNode = currentNode.next;
            index++;
        }
        //make sure we found matching element
        if( currentNode == null ){
            return -1;
        }
        else{
            return index;
        }
    }

    /** Remove the element with specified index
     *  All elements with higher index have their
     *  index reduced by 1
     *  @throws IndexOutOfBoundsException when
     *  index is not between 0 and size - 1
     *  @return removed element*/
    @Override
    public T remove(int index) {
        
        checkIndex( index );
        
        T removedElement;
        if( index == 0 ){//remove first node
            removedElement = firstNode.element;
            firstNode = firstNode.next;
        }
        else{//use q to get to predecesor of desired node
            ChainNode<T> q = firstNode;
            for( int i = 0; i < index - 1; i++ ){
                q = q.next;
            }
            removedElement = q.next.element;
            //remove desired node
            q.next = q.next.next;
        }
        size--;
        return removedElement;
           
    }
    
    /** Insert an element with specified index
     *  All elements with equal or higher index
     *  have their index increased by 1.
     *  @throws IndexOutOfBoundsException when
     *  index is not between 0 and size
     *  @param theElement
     *  @param index
     */
    @Override
    @SuppressWarnings("Convert2Diamond")
    public void add(int index, T theElement) {
        if( index < 0 || index > size ){
            //invalid list position
            throw new IndexOutOfBoundsException
                ( "index = " + index + "  size = " + size );
        }
        
        if( index == 0 ){
            //Insert at front
            firstNode = new ChainNode<T>( theElement , firstNode );
        }
        else{ //find predecessor of new element
            ChainNode<T> p = firstNode;
            for( int i = 0 ; i < index - 1 ; i++ ){
                p = p.next;
            }
            //Insert after p
            p.next = new ChainNode<T>( theElement , p.next );
        }
        size++;
    }

    /**convert to a String*/
    @Override
    public String toString( ){
        StringBuilder s = new StringBuilder( "[" );
        
        //Put elements into the buffer
        for( T x : this ){
            s.append( Objects.toString( x ) + ", " );
        }
        if( size > 0 ){
            s.setLength( s.length( ) - 2 );//remove last
        } 
        s.append( "]" );
        
        //Create equivalent String
        return new String( s );
    }
    
    /**Create and return an interator*/
    @Override
    public Iterator<T> iterator() {
        return new ChainIterator( );
    }
    
    /**Class Iterator*/
    private class ChainIterator implements Iterator<T>{
        
        //Data Members
        private ChainNode<T> nextNode;
        
        //Constructor
        public ChainIterator( ){
            nextNode = firstNode;
        }
        
        //Methods
        
        /**
         *  @return true if list has a next element
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        /** 
         * @return next element in the list
         * @throws NoSuchElementException
         * when there is no next element
         */
        @Override
        public T next() {
            if( nextNode != null ){
                T elementToReturn = nextNode.element;
                nextNode = nextNode.next;
                return elementToReturn;
            }
            else{
                throw new NoSuchElementException( "No next element" );
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
