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
    
    public Coordinate positionIn;
    public Coordinate positionOut;
    
    
    //Constructors
    public Teleport(){
        this( new Coordinate(), new Coordinate(), false );
    }
    
    public Teleport(Coordinate coordinateIn, Coordinate coordinateOut , boolean state ){
        positionIn = coordinateIn;
        positionOut = coordinateOut;
        this.state = state;
    }
}
