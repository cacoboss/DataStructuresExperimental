package co.edu.unal.ds.queue;

public interface Queue<T> {
	boolean isEmpty( );
	T getFrontElement();
	T getRearElement();
	void put( T elem );
	T remove( );
}
