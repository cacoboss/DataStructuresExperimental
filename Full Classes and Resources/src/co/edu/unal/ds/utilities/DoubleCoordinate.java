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
public class DoubleCoordinate extends Coordinate{
    
    //Fields
    public long row2;
    public long col2;
    
    //Constructors
    public DoubleCoordinate( ){
        this( 0 , 0 , 0 , 0 );
    }
    
    public DoubleCoordinate( long row1, long col1 , long row2, long col2 ){
        super.row1 = row1;
        super.col1 = col1;
        this.row1 = row2;
        this.col1 = col2;
    }
    
    //Convert to String, suitable for output
    @Override
    public String toString( ){
        return new String( super.row1 + " " + super.col1 + " " + row2 + " " + col2 );
    }
    
    
}
