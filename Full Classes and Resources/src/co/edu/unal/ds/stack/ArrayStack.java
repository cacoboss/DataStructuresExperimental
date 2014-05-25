/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 package co.edu.unal.ds.stack;
 
 import co.edu.unal.ds.interfaces.Stack;
import java.util.EmptyStackException;

 public class ArrayStack<T> implements Stack<T> {
 	
	//Fields
	int top;     //Current top of the stack
	T[ ] stack;  //element array
	
	//Constructors
	
	/** Crreate a stack with the initial given capacity
        * @param initialCapacity
	* @throws IllegalArgumentExcepttion when initialCapacity < 1
	*/
        @SuppressWarnings("uncheked")
	public ArrayStack( int initialCapacity ){
            if( initialCapacity < 1){
                throw new IllegalArgumentException
                    ("initialCapacity must be > 1");
            }
            stack = ( T[] ) new Object[ initialCapacity ];
            top = -1;
	}
	/**Creates an Stack with initial capacity 10
         */
	public ArrayStack( ){
		this( 10 );
	}
	
	//Methods
        
        /**@return true if stack is Empty
         */
        @Override
	public boolean isEmpty( ){
            return top == -1;
	}
        
        /**@return top element of the stack
         * @throws EmptyStackException when the stack is empty
         */
	@Override
	public T peek( ){
            if( isEmpty() ){
                throw new EmptyStackException( );
            }
            return stack[ top ] ;
	}
	
        /**add theElement to the top of the stack
         * @param theElement
         */
        @Override
        @SuppressWarnings("uncheked")
	public void push( T theElement ){
	    //increases array size if necesary
            if( top == stack.length - 1 ){
                T[] old = stack;
                stack = ( T[] ) new Object[ 2 * stack.length ];
                System.arraycopy(old, 0, stack, 0, old.length);
            }
            
            //Put theElement at the top of the stack
            stack[ ++top ] = theElement;
	}
	
        /**Remove top element of stack and return it
         * @return topElement
         * @throws EmptyStackException when the stack is empty
         */
        @Override
	public T pop( ){
	    if( isEmpty() ){
                throw new EmptyStackException();
            }
            T topElement = stack[ top ];
            stack[ top-- ] = null; //enable garbage Collection
            return topElement;
	}
 }
