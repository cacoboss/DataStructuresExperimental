/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.unal.ds.main;

import co.edu.unal.ds.queue.*;
import co.edu.unal.ds.util.Position;
import java.util.Scanner;

/**
 *
 * @author CIRO and DAVID
 */
public class PaintingWalls {
    
    //Fields
    public static char[][] maze;
    public static int rowSize, colSize;
    public static String initial;
    public static char[] currentRow;
    public static Position here;
    public static int numOfNbrs = 4;
    public static int littersOfPaint;
    
    //Main
    public static void main (String[] args){
        inputMaze();
        isOkayToPaint();
    }
    
    //Methods
    public static void inputMaze( ){
        Scanner sc = new Scanner( System.in );
        System.out.println( "Please enter the numbre of rows: " );
        rowSize = sc.nextInt();
        System.out.println( "Please enter the numbre of columns: " );
        colSize = sc.nextInt();
        System.out.println( "Please enter the maze: " );
        //Initializing maze
        maze = new char[ rowSize + 4 ][ colSize + 4];
        for(int i = 0; i < rowSize; i++ ){
            initial = sc.next();
            currentRow = initial.toCharArray();
            for(int j = 0; j < colSize; j++){
                maze[i + 2][j + 2] = currentRow[j];
            }
        }
        System.out.println();
    }
    
    public static void isOkayToPaint( ){
        //Initializing offsets
        Position[] offsets = new Position[4];
        offsets[0] =  new Position( -1 , 0 ); //Up
        offsets[1] =  new Position(  0 , 1 ); //Right
        offsets[2] =  new Position(  1 , 0 ); //Down
        offsets[3] =  new Position( 0 , -1 ); //Left
        
        //Initialing External Corridor   ///****///
        for(int i = 0; i < rowSize + 4; i++){
            maze[ i ][ 0 ] = '.';
            maze[ i ][ 1 ] = '.';
            maze[ i ][ rowSize + 2 ] = '.';
            maze[ i ][ rowSize + 3 ] = '.';
        }
        
        for(int i = 0; i < colSize + 4; i++){
            maze[ 0 ][ i ] = '.';
            maze[ 1 ][ i ] = '.';
            maze[ colSize + 2 ][ i ] = '.';
            maze[ colSize + 3 ][ i ] = '.';
        }
   
        //Initializing the Queue
        Queue<Position> queuePaint = new LinkedQueue<>();
        Position nbr = new Position(1,1);
        
        //Print the laberint
        /*for(int i = 0; i < rowSize + 4; i++){
            for(int j = 0; j < colSize + 4; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
         System.out.println();*/
        
        //Scan maze and the counting
        for(int i = 1; i < rowSize + 2; i++){  //row i of maze
            for(int j = 1 ; j < colSize + 2; j++){  //col j of maze
                if(maze[i][j] == '.'){ //Posible Component
                    maze[i][j] = '*'; //Position already checked
                //    littersOfPaint = littersOfPaint + 1; ///****///
                    here = new Position( i , j );
                    System.out.println("Punto inicio Row:" + here.row + " y Col:" + here.col);
                    do{ //Find Walls for painting
                        for(int aux = 0; aux < 3 ; aux++){
                            //Check all neighbors
                            nbr.row = (here.row + offsets[aux].row);
                            nbr.col = (here.col + offsets[aux].col);
                            System.out.println("Los indices son Row:" + nbr.row + " y Col:" + nbr.col);
                            if( maze[ nbr.row ][ nbr.col ] == '#' ){
                                //Possible Wall for painting
                                littersOfPaint = littersOfPaint + 1;              
                            }else {
                                queuePaint.put(new Position(nbr.row,nbr.col));
                            }
                            
                            //Revisando que funcione
                            /*for(int aux1 = 0; aux1 < rowSize + 4; aux1++){
                                for(int aux2 = 0; aux2 < colSize + 4; aux2++){
                                    System.out.print(maze[aux1][aux2]);
                                }
                                System.out.println();
                            }
                            System.out.println();*/
                            
                        }
                        //Unexplored Path
                        here = queuePaint.remove();
                    }
                    while( here != null );
                }
            }
        }
        System.out.println("Total amount of paint used: " + littersOfPaint);
    }
    
}
