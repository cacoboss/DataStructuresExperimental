/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.utilities;

/**
 *
 * @author CIRO
 */
public class Teleport {
    
    //Fields
    public boolean state;
    public DoubleCoordinate position;
    
    //Constructors
    
    public Teleport(){
        
    }
    
    public Teleport( DoubleCoordinate coordinate, boolean state ){
        position = coordinate;
        state = true;
    }
}
