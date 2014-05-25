/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.application;

import co.edu.unal.ds.utilities.Coordinate;

/**
 *
 * @author CIRO
 */
public class ThreeTeleports {
    
    //Fields 
    private long hx, hy, ans;
    private long[][] in, out;
    
    private long manhattanDistance( Coordinate p1, Coordinate p2 ){
        
        long distance;
        distance = Math.abs( p2.row1 - p1.row1 ) + Math.abs( p2.col1 - p1.col1 );
        return distance;
    }
    
}
