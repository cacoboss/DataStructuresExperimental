/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.interfaces;

/**
 *
 * @author CIRO
 * @param <T>
 */
public interface LinearList<T> {
    
    boolean isEmpty( );
    int size( );
    T get( int index );
    int indexOf( T theElement );
    T remove( int index );
    void add( int index , T theElement );
    @Override
    String toString( );
}
