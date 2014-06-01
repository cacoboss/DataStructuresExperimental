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
public class Coordinate {
    
    //Fields
    public long row1;
    public long col1;
    
    //Constructors
    public Coordinate( ){
        this( 0 , 0 );
    }
    
    public Coordinate( long row, long col ){
        this.row1 = row;
        this.col1 = col;
    }
    
    //Convert to String, suitable for output
    @Override
    public String toString( ){
        return new String( row1 + " " + col1 );
    }
}
