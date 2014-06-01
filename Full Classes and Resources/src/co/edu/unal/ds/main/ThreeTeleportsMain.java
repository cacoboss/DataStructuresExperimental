/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.main;

import co.edu.unal.ds.application.ThreeTeleports;

/**
 *
 * @author CIRO
 */
public class ThreeTeleportsMain {
    
    public static void main( Strings [] args ){
        	System.out.println(new ThreeTeleports().shortestDistance( 0, 0, 1000,1000, new String[]{"100 100 200 200", "230 100 50 50", "40 40 50 50"} ) );
    }
    
}
