/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.stack;

import co.edu.unal.ds.chain.ChainNode;
import co.edu.unal.ds.interfaces.Stack;
import java.util.EmptyStackException;

/**
 *
 * @author CIRO
 */
public class LinkedStack<T> implements Stack<T> {

    //Fields
    protected ChainNode<T> topNode;
    
    //Constructors
    public LinkedStack( ){
        topNode = null;
    }
        
    //Methods
    /**@return true if stack is empty
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    /**@return top element of the stack
    * @throws EmptyStackException when the stack is empty
    */
    @Override
    public T peek() {
        if( isEmpty() ){
            throw new EmptyStackException();
        }
        return topNode.element;
    }

    /**add theObject to the top of the stack
     */
    @Override
    public void push(T theObject) {
        topNode = new ChainNode<T>( theObject , topNode );
    }

    /**remove top element of stack and return it
     * @throws EmptyStackException when the stack is empty
     */
    @Override
    public T pop() {
        if( isEmpty() ){
            throw new EmptyStackException();
        }
        T topElement = topNode.element;
        topNode = topNode.next;
        return topElement;
    }
    
}
