/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

/**
 *
 * @author CIRO
 * @param <T>
 */
public interface Queue <T> {
    
    boolean isEmpty( );
    T getFrontElement( );
    T getRearElement( );
    void put ( T theObject );
    T remove ( );
    
}
