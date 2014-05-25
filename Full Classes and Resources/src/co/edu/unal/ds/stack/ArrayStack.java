/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 package co.edu.unal.ds.stack;
 
 public class ArrayStack<T> implements Stack<T> {
 	
	//Fields
	int top;     //Current top of the stack
	T[ ] stack;  //element array
	
	//Constructors
	
	/** Crreate a stack with the initial given capacity
	* @throws IllegalArgumentExcepttion when initialCapacity < 1
	*/
	public ArrayStack( int initialCapacity ){
		
	}
	
	public ArrayStack( ){
		this( 10 );
	}
	
	//Methods
	public boolean isEmpty( ){
		
	}
	
	public T peek( ){
		
	}
	
	public void push( T theElement ){
		
	}
	
	public T pop( ){
		
	}
 }
