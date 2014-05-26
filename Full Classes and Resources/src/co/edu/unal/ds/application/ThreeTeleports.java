/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.application;

import co.edu.unal.ds.interfaces.Stack;
import co.edu.unal.ds.stack.LinkedStack;
import co.edu.unal.ds.utilities.Coordinate;
import co.edu.unal.ds.utilities.DoubleCoordinate;
import co.edu.unal.ds.utilities.Teleport;

/**
 *
 * @author CIRO
 */
public class ThreeTeleports {
    
    //Fields 
    /*private long hx, hy, ans;
    private long[][] in, out;*/
    private Coordinate me1, me2;
    private Coordinate house;
    private int[] offset = {-2,-1,1,2};
    
    
    //Data Structures
    Teleport[] theTeleports = new Teleport[3];
    Stack<Long> solution = new LinkedStack<>();
    Stack<Teleport> solutionsUsed = new LinkedStack<>();

    //Methods
    private long manhattanDistance( Coordinate p1, Coordinate p2 ){
        long distance;
        distance = Math.abs( p2.row1 - p1.row1 ) + Math.abs( p2.col1 - p1.col1 );
        return distance;
    }
    
    private boolean isOk(int index, Teleport[] elements, int[] offset){
        int aux = 0;
        for(int i = 0; i < 4; i++){
            if(index + offset[i] < elements.length  && index + offset[i] > 0)
                aux = aux + 1;
        }
        return false;
    }
    
    private void solveProblem(){
        
        long currentSolution;
        solution.push( manhattanDistance(me1, house) );
        
        
        do{
            for(int i = 0; i < theTeleports.length; i++  ){
                if( !solutionsUsed.isEmpty() ){
                    if()
                }else{
                    solutionsUsed.push(theTeleports[i]);
                }
                
                
                
                
                
                
            }
            
            if(currentSolution < solution.peek()){
                solution.push(currentSolution);
            }
            
            
        }while(true);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        while( me2 != house ){
//            
//            while ( solution.peek() < currentSolution ){
//                
//                for( int i = 0; i < 3; i++ ){
//                    if( (manhattanDistance(me1, theTeleports[i].positionIn))
//                         < manhattanDistance(me1, theTeleports[i].positionOut)){
//                        
//                        
//                        solutionsUsed.push(theTeleports[i]);
//                                
//                        currentSolution = manhattanDistance(me1, theTeleports[i].positionIn);
//                        me1 = theTeleports[i].positionIn;
//                        theTeleports[i].state = true
//                        
//                        
//                    } else if( (manhattanDistance(me1, theTeleports[i].positionIn))
//                         < manhattanDistance(me1, theTeleports[i].positionOut)){
//                        
//                    } else{
//                        
//                    }
//                            
//                        
//                    
//                            
//                }
//                
//                
//            }
            
        }
        
    
    
    public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports){
        /*ans = Integer.;
        hx = xHome;
        hy = yHome;
        in = new long[3][2];
        out = new long[3][2];
        for( int i = 0; i < 3; i++ ){
        String pars[] = teleports[i].split(" ");
        in[i][0] = Long.parseLong( pars[0] );
        in[i][1] = Long.parseLong( pars[1] );
        out[i][0] = Long.parseLong( pars[2] );
        out[i][1] = Long.parseLong( pars[3] );
        }
        solve( xMe, yMe, 0, 0 );
        return (int)ans;*/
        
        //Initializing Variables
        me1 = me2 =  new Coordinate((long)xMe,(long)yMe);
        house = new Coordinate((long)xHome,(long)yHome);
        
        //Initializing Teleports
        for( int i = 0; i < 3; i++ ){
            String pars[] = teleports[i].split(" ");
            theTeleports[ i ] = (new Teleport(new Coordinate(Long.parseLong(pars[0]),Long.parseLong(pars[1])),
                                              new Coordinate(Long.parseLong(pars[2]),Long.parseLong(pars[3])),
                                              false));
        }
        long answer = 0;
        
        return (int)answer;
        
        
    }
}
