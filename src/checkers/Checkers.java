/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;
import java.util.Scanner;


//Sean Liam Kuehl
//3/21/2020
//Checkers.java
//create a checkers game with move, jump and multi jump features


/**
 *
 * @author kuehl family
 */
public class Checkers {
    
    public static String[][] KingCheck(String[][] board){
        for (int row = 0; row<board.length;row++){
            for (int column = 0; column<board.length;column++){
                if (row == 7 && board[row][column].equals("x")){
                    board[row][column] = "xk";
                }
                if (row == 0 && board[row][column].equals("o")){
                    board[row][column] = "ok";
                }
            }
        }
        
        return board;
    }
    
    public static String[][] KingMove(String[][] board, int[] pieceCoord,int[][] cList, String symbol){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        int[] topLeft = {pieceCoord[0]-1, pieceCoord[1]-1};
        int[] topRight = {pieceCoord[0]-1, pieceCoord[1]+1};
        int[] bottomLeft = {pieceCoord[0]+1, pieceCoord[1]-1};
        int[] bottomRight = {pieceCoord[0]+1, pieceCoord[1]+1};
        
        
        if (moveCoord[0] == topLeft[0] && moveCoord[1] == topLeft[1]){
            board[moveCoord[0]][moveCoord[1]] = symbol;
            board[pieceCoord[0]][pieceCoord[1]] = "#";
        }
        if (moveCoord[0] == topRight[0] && moveCoord[1] == topRight[1]){
            board[moveCoord[0]][moveCoord[1]] = symbol;
            board[pieceCoord[0]][pieceCoord[1]] = "#";
        }
        if (moveCoord[0] == bottomLeft[0] && moveCoord[1] == bottomLeft[1]){
            board[moveCoord[0]][moveCoord[1]] = symbol;
            board[pieceCoord[0]][pieceCoord[1]] = "#";
        }
        if (moveCoord[0] == bottomRight[0] && moveCoord[1] == bottomRight[1]){
            board[moveCoord[0]][moveCoord[1]] = symbol;
            board[pieceCoord[0]][pieceCoord[1]] = "#";
        }
        
        
        return board;
    }
    
    public static String[][] KingJump(String[][] board, int[] pieceCoord,int[][] cList, String symbol){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        
        int[] topLeft = {pieceCoord[0]-2, pieceCoord[1]-2};  
        int[] topLeftMiddle = {pieceCoord[0]-1, pieceCoord[1]-1};
        
        int[] topRight = {pieceCoord[0]-2, pieceCoord[1]+2};
        int[] topRightMiddle = {pieceCoord[0]-1, pieceCoord[1]+1};
        
        int[] bottomLeft = {pieceCoord[0]+2, pieceCoord[1]-2};
        int[] bottomLeftMiddle = {pieceCoord[0]+1, pieceCoord[1]-1};
        
        int[] bottomRight = {pieceCoord[0]+2, pieceCoord[1]+2};
        int[] bottomRightMiddle = {pieceCoord[0]+1, pieceCoord[1]+1};
        
        //int[] leftMiddleMoveCoord = {pieceCoord[0]-1, pieceCoord[1]-1}; //this goes one down to the left
        
        
        
        if (moveCoord[0] == topLeft[0] && moveCoord[1] == topLeft[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[topLeftMiddle[0]][topLeftMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == topRight[0] && moveCoord[1] == topRight[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[topRightMiddle[0]][topRightMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == bottomLeft[0] && moveCoord[1] == bottomLeft[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[bottomLeftMiddle[0]][bottomLeftMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == bottomRight[0] && moveCoord[1] == bottomRight[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[bottomRightMiddle[0]][bottomRightMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        
        
        return board;
    }
    
    public static String[][] KingMultiJump(String[][] board, int[] pieceCoord,int[][] cList, String symbol){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        
        int[] topLeft = {pieceCoord[0]-2, pieceCoord[1]-2};  
        int[] topLeftMiddle = {pieceCoord[0]-1, pieceCoord[1]-1};
        
        int[] topRight = {pieceCoord[0]-2, pieceCoord[1]+2};
        int[] topRightMiddle = {pieceCoord[0]-1, pieceCoord[1]+1};
        
        int[] bottomLeft = {pieceCoord[0]+2, pieceCoord[1]-2};
        int[] bottomLeftMiddle = {pieceCoord[0]+1, pieceCoord[1]-1};
        
        int[] bottomRight = {pieceCoord[0]+2, pieceCoord[1]+2};
        int[] bottomRightMiddle = {pieceCoord[0]+1, pieceCoord[1]+1};
        
        //int[] leftMiddleMoveCoord = {pieceCoord[0]-1, pieceCoord[1]-1}; //this goes one down to the left
        
        
        int row = 0;
        int column = 0;
        int[] item = new int[2];
        int length = 0;
        //these will be kept for later
        
        
        
        
        if (moveCoord[0] == topLeft[0] && moveCoord[1] == topLeft[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[topLeftMiddle[0]][topLeftMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == topRight[0] && moveCoord[1] == topRight[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[topRightMiddle[0]][topRightMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == bottomLeft[0] && moveCoord[1] == bottomLeft[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[bottomLeftMiddle[0]][bottomLeftMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == bottomRight[0] && moveCoord[1] == bottomRight[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[bottomRightMiddle[0]][bottomRightMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        
        for (int i = 0; i<cList.length;i++){
            if (cList[i][0] == -1){
                
            }
            else {
                length += 1;
            }
        }
        
        
        for (int i = 0; i < length-1; i++){
            
            //the 7 above is because the last jump will put the piece at the
            //last coord, thus making a jump based on the last item impossible
            item = cList[i];
            row = item[0];
            column = item[1];
            
            pieceCoord = moveCoord; //it's at the last place it moved to, now for another jump
            moveCoord = cList[i+1];
            
            topLeft[0] = pieceCoord[0]-2;
            topLeft[1] = pieceCoord[1]-2;
            
            
            topLeftMiddle[0] = pieceCoord[0]-1;
            topLeftMiddle[1] = pieceCoord[1]-1;
        
            //topRight = {pieceCoord[0]-2, pieceCoord[1]+2};
            topRight[0] = pieceCoord[0]-2;
            topRight[1] = pieceCoord[1]+2;
            
            //topRightMiddle = {pieceCoord[0]-1, pieceCoord[1]+1};
            topRightMiddle[0] = pieceCoord[0]-1;
            topRightMiddle[1] = pieceCoord[1]+1;
        
            //bottomLeft = {pieceCoord[0]+2, pieceCoord[1]-2};
            bottomLeft[0] = pieceCoord[0]+2;
            bottomLeft[1] =  pieceCoord[1]-2;
            
            //bottomLeftMiddle = {pieceCoord[0]+1, pieceCoord[1]-1};
            bottomLeftMiddle[0] = pieceCoord[0]+1;
            bottomLeftMiddle[1] = pieceCoord[0]-1;
        
            //bottomRight = {pieceCoord[0]+2, pieceCoord[1]+2};
            bottomRight[0] = pieceCoord[0]+2;
            bottomRight[1] = pieceCoord[0]+2;
            
            //bottomRightMiddle = {pieceCoord[0]+1, pieceCoord[1]+1};
            bottomRightMiddle[0] = pieceCoord[0]+1;
            bottomRightMiddle[1] = pieceCoord[1]+1;
        
        //int[] leftMiddleMoveCoord = {pieceCoord[0]-1, pieceCoord[1]-1}; //this goes one down to the left
        
        
        
        if (moveCoord[0] == topLeft[0] && moveCoord[1] == topLeft[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[topLeftMiddle[0]][topLeftMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == topRight[0] && moveCoord[1] == topRight[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[topRightMiddle[0]][topRightMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == bottomLeft[0] && moveCoord[1] == bottomLeft[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[bottomLeftMiddle[0]][bottomLeftMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else if (moveCoord[0] == bottomRight[0] && moveCoord[1] == bottomRight[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[bottomRightMiddle[0]][bottomRightMiddle[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = symbol; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
            
        }
        
        
        return board;
        
        
    }
    
    public static String[][] OMultiJump(String[][] board, int[] pieceCoord, int[][] cList){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        int[] leftMoveCoord = {pieceCoord[0]-2, pieceCoord[1]-2}; //this goes two down to the left
        int[] rightMoveCoord = {pieceCoord[0]-2, pieceCoord[1]+2};  //this goes two down to the right
        
        int[] leftMiddleMoveCoord = {pieceCoord[0]-1, pieceCoord[1]-1}; //this goes one down to the left
        int[] rightMiddleMoveCoord = {pieceCoord[0]-1, pieceCoord[1]+1};  //this goes one down to the right
        //the above two are because a piece move to one of the two squares diagonal infront of it
        
        int row = 0;
        int column = 0;
        int[] item = new int[2];
        int length = 0;
        //these will be kept for later
        
        
        if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[leftMiddleMoveCoord[0]][leftMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "o"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[rightMiddleMoveCoord[0]][rightMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "o"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        //all of above is for the first jump only
        
        //this is to determine the actual length of the list so it doesn't use
        //a -1,-1 (empty) list place and say the move was a bad coord
        for (int i = 0; i<cList.length;i++){
            if (cList[i][0] == -1){
                
            }
            else {
                length += 1;
            }
        }
        
        
        
        for (int i = 0; i < length-1; i++){
            
            //the 7 above is because the last jump will put the piece at the
            //last coord, thus making a jump based on the last item impossible
            item = cList[i];
            row = item[0];
            column = item[1];
            
            pieceCoord = moveCoord; //it's at the last place it moved to, now for another jump
            moveCoord = cList[i+1];
            
            
            leftMoveCoord[0] = pieceCoord[0]-2; //this goes two down to the left
            leftMoveCoord[1] = pieceCoord[1] -2; //this goes two down to the left
            
            rightMoveCoord[0] = pieceCoord[0] -2; //this goes two down to the right
            rightMoveCoord[1] = pieceCoord[1] +2; //this goes two down to the right
        
            
            leftMiddleMoveCoord[0] = pieceCoord[0] -1; //this goes one down to the left
            leftMiddleMoveCoord[1] = pieceCoord[1]-1; //this goes one down to the left
            
            
            rightMiddleMoveCoord[0] = pieceCoord[0]-1; //this goes one down to the right
            rightMiddleMoveCoord[1] = pieceCoord[1]+1; //this goes one down to the right
            
            //System.out.println("");
            //System.out.println(moveCoord[0]+"  "+moveCoord[1] + "    hello");
            //System.out.println(rightMoveCoord[0]+"  "+rightMoveCoord[1] + "    there");
            //System.out.println(leftMoveCoord[0]+"  "+leftMoveCoord[1]+"   sir");
            
            
            
            if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
                board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
                board[leftMiddleMoveCoord[0]][leftMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
                board[moveCoord[0]][moveCoord[1]] = "0"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[rightMiddleMoveCoord[0]][rightMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "o"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
            
        }
        
        
        return board;
    }
    
    public static String[][] OJump(String[][] board, int[] pieceCoord, int[][] cList){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        int[] leftMoveCoord = {pieceCoord[0]-2, pieceCoord[1]-2}; //this goes two down to the left
        int[] rightMoveCoord = {pieceCoord[0]-2, pieceCoord[1]+2};  //this goes two down to the right
        
        int[] leftMiddleMoveCoord = {pieceCoord[0]-1, pieceCoord[1]-1}; //this goes one down to the left
        int[] rightMiddleMoveCoord = {pieceCoord[0]-1, pieceCoord[1]+1};  //this goes one down to the right
        //the above two are because a piece move to one of the two squares diagonal infront of it
        
        
        if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[leftMiddleMoveCoord[0]][leftMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "o"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[rightMiddleMoveCoord[0]][rightMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "o"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        
        
        return board;
    }
    
    public static String[][] OMove(String[][] board, int[] pieceCoord, int[][] cList){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        int[] leftMoveCoord = {pieceCoord[0]-1, pieceCoord[1]-1}; //this goes one down to the left
        int[] rightMoveCoord = {pieceCoord[0]-1, pieceCoord[1]+1};  //this goes one down to the right
        
        
        if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[moveCoord[0]][moveCoord[1]] = "o"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[moveCoord[0]][moveCoord[1]] = "o"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        
        return board;
    }
    
    public static String[][] JumpTest(String[][] board){
        //this was used to check the piece movements. 
        int len = board.length;
        String exes = "x";
        String oes = "o";
        String empty = "#";
        for (int row = 0; row<len;row++){
            for (int column = 0; column<len;column++){
                if (row == 7 && column == 0){
                    board[row][column] = oes;
                }
                else if (row == 6 && column == 1){
                    board[row][column] = exes;
                }
                else if (row == 2 && column == 3){
                    board[row][column] = oes;
                }
                else if (row == 3 && column == 2){
                    board[row][column] = exes;
                }
                else if (row == 6 && column == 5){
                    board[row][column] = exes;
                }
                else if (row == 7 && column == 6){
                    board[row][column] = oes;
                }
                else {
                    board[row][column] = empty;
                }
            }
        }
        
        return board;
    }
    
    public static String[][] XMultiJump(String[][] board, int[] pieceCoord, int[][] cList){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        int[] leftMoveCoord = {pieceCoord[0]+2, pieceCoord[1]-2}; //this goes two down to the left
        int[] rightMoveCoord = {pieceCoord[0]+2, pieceCoord[1]+2};  //this goes two down to the right
        
        int[] leftMiddleMoveCoord = {pieceCoord[0]+1, pieceCoord[1]-1}; //this goes one down to the left
        int[] rightMiddleMoveCoord = {pieceCoord[0]+1, pieceCoord[1]+1};  //this goes one down to the right
        //the above two are because a piece move to one of the two squares diagonal infront of it
        
        int row = 0;
        int column = 0;
        int[] item = new int[2];
        int length = 0;
        //these will be kept for later
        
        
        if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[leftMiddleMoveCoord[0]][leftMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[rightMiddleMoveCoord[0]][rightMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        //all of above is for the first jump only
        
        //this is to determine the actual length of the list so it doesn't use
        //a -1,-1 (empty) list place and say the move was a bad coord
        for (int i = 0; i<cList.length;i++){
            if (cList[i][0] == -1){
                
            }
            else {
                length += 1;
            }
        }
        
        
        
        for (int i = 0; i < length-1; i++){
            
            //the 7 above is because the last jump will put the piece at the
            //last coord, thus making a jump based on the last item impossible
            item = cList[i];
            row = item[0];
            column = item[1];
            
            pieceCoord = moveCoord; //it's at the last place it moved to, now for another jump
            moveCoord = cList[i+1];
            
            
            leftMoveCoord[0] = pieceCoord[0]+2; //this goes two down to the left
            leftMoveCoord[1] = pieceCoord[1] -2; //this goes two down to the left
            
            rightMoveCoord[0] = pieceCoord[0] +2; //this goes two down to the right
            rightMoveCoord[1] = pieceCoord[1] +2; //this goes two down to the right
        
            
            leftMiddleMoveCoord[0] = pieceCoord[0] +1; //this goes one down to the left
            leftMiddleMoveCoord[1] = pieceCoord[1]-1; //this goes one down to the left
            
            
            rightMiddleMoveCoord[0] = pieceCoord[0]+1; //this goes one down to the right
            rightMiddleMoveCoord[1] = pieceCoord[1]+1; //this goes one down to the right
            
            //System.out.println("");
            //System.out.println(moveCoord[0]+"  "+moveCoord[1] + "    hello");
            //System.out.println(rightMoveCoord[0]+"  "+rightMoveCoord[1] + "    there");
            //System.out.println(leftMoveCoord[0]+"  "+leftMoveCoord[1]+"   sir");
            
            
            
            if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
                board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
                board[leftMiddleMoveCoord[0]][leftMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
                board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[rightMiddleMoveCoord[0]][rightMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
            
        }
        
        
        return board;
    }
    
    
    public static String[][] XJump(String[][] board, int[] pieceCoord, int[][] cList){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        int[] leftMoveCoord = {pieceCoord[0]+2, pieceCoord[1]-2}; //this goes two down to the left
        int[] rightMoveCoord = {pieceCoord[0]+2, pieceCoord[1]+2};  //this goes two down to the right
        
        int[] leftMiddleMoveCoord = {pieceCoord[0]+1, pieceCoord[1]-1}; //this goes one down to the left
        int[] rightMiddleMoveCoord = {pieceCoord[0]+1, pieceCoord[1]+1};  //this goes one down to the right
        //the above two are because a piece move to one of the two squares diagonal infront of it
        
        
        if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[leftMiddleMoveCoord[0]][leftMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[rightMiddleMoveCoord[0]][rightMiddleMoveCoord[1]] = "#"; //get rid of the jumped over piece
            board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        
        
        return board;
    }
    
    
    public static String[][] XMove(String[][] board, int[] pieceCoord, int[][] cList){
        int[] moveCoord = {cList[0][0], cList[0][1]};
        int[] leftMoveCoord = {pieceCoord[0]+1, pieceCoord[1]-1}; //this goes one down to the left
        int[] rightMoveCoord = {pieceCoord[0]+1, pieceCoord[1]+1};  //this goes one down to the right
        
        
        if (moveCoord[0] == leftMoveCoord[0] && moveCoord[1] == leftMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else if (moveCoord[0] == rightMoveCoord[0] && moveCoord[1] == rightMoveCoord[1]){
            board[pieceCoord[0]][pieceCoord[1]] = "#"; //empty where we are moving the piece from
            board[moveCoord[0]][moveCoord[1]] = "x"; //fill where we are move the piece to
        }
        else {
            System.out.println("You entered in a bad coordinate. Please play again.");
            System.exit(0);
        }
        
        
        
        
        
        return board;
    }
    
    public static String[][] Setup(String[][] board){
        int len = board.length;
        String exes = "x";
        String oes = "o";
        String empty = "#";
        for (int row = 0; row<len;row++){
            for (int column = 0; column<len;column++){
                if ((row == 0 || row == 2) && column % 2 > 0){
                    board[row][column] = exes;
                }
                if (row == 1 && column % 2 == 0){
                    board[row][column] = exes;
                }
                
                if ((row == 5 || row == 7) && column % 2 > 0){
                    board[row][column] = oes;
                }
                if (row == 6 && column % 2 == 0){
                    board[row][column] = oes;
                }
                if (board[row][column] == null){
                    board[row][column] = empty;
                }
            }
        }
        
        return board;
    }
    
    public static int[] CoordinateConversion(String place){
        //make sure the coordinates are actually valid
        char[] convertRow = {'A', '0', 'B', '1', 'C', '2', 'D', '3', 'E', '4', 'F', '5', 'G', '6', 'H', '7'};
        int row = (Integer.valueOf(place.charAt(1))-48)-1;
        
        char column = place.charAt(0);
        int[] coordinates = new int[2];
        for (int i = 0; i< convertRow.length;i++){
            
            if (column == convertRow[i]){
                coordinates[1] = (Integer.valueOf(convertRow[i+1]))-48;
            }
        }
        
        coordinates[0] = row;
        //it goes row, column
        
        return coordinates;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[8][8];
        board = Setup(board);
        int len = board.length;
        int[][] cList = new int[8][2];
        //below sets all values to -1
        //this will help to see if they are never changed later
        //as 0,0 is an actual coordinate
        for (int i = 0;i<cList.length;i++){
            for (int k = 0; k<2;k++){
                cList[i][k] = -1;
            }
        }
        
        
        //twelve colored disks, black moves first, it's 64 squares
        //make a function to handle moves, handle jumps and double jumps, handle exiting the game
        boolean running = true;
        boolean moreToJump = true;
        int counter = 0;
        int turn = 0;
        String coordinate = "";
        int[] intPieceCoord = new int[2];
        int subCounter = 0;
        
        
        System.out.println("Hello and welcome to checkers.");
        
        while (running == true){
            counter = 0;
            System.out.println("A  B  C  D  E  F  G  H");
            for (int row = 0; row<len; row++){
            System.out.println("");
            
            System.out.println("");
            counter += 1;
            for (int column = 0; column<len;column++){
                if (column == 7){
                    System.out.println(board[row][column]+"    "+counter);
                }
                else {
                    System.out.print(board[row][column]+"  ");
                }
                
                
                
            }
        }
            //print out the board
            
            
            //that's the output done
            //exes goes first
            if (turn == 0){
                board = KingCheck(board);
                System.out.println("X player, it's your turn.");
                System.out.println("Please enter the coordinate of the piece you want to move.");
                coordinate = sc.next(); 
                intPieceCoord = CoordinateConversion(coordinate);  //this will convert it
                //so it can be used in the grid
                
                //make sure the piece coord is both the right kind and legal
                if (board[intPieceCoord[0]][intPieceCoord[1]].equals("x") || board[intPieceCoord[0]][intPieceCoord[1]].equals("xk")){
                    
                }
                else {
                    System.out.println("Sorry, you entered the wrong coordinate. Try again next time.");
                    System.exit(0);
                }
                
                
                System.out.println("Enter the coordinate of your move or jump spot.");
                subCounter = 0;
                moreToJump = true;
                while (moreToJump == true){
                    
                    System.out.println("If you wish to do a multi-jump, enter where ");
                    System.out.println("the piece will be after the first jump, then");
                    System.out.println("the second, etc. If done, enter DONE."); 
                    coordinate = sc.next();
                    if (!coordinate.equals("DONE")){
                        cList[subCounter] = CoordinateConversion(coordinate);
                    }
                    else {
                        moreToJump = false;
                    }
                    subCounter += 1;
                    
                }
                //this has gotten all we will need from the user
                //now we find out which type of movement they are doing
                
                //if there is only one coordinate in the list
                if (board[intPieceCoord[0]][intPieceCoord[1]].equals("x")){
                    if (cList[1][0] == -1 && cList[1][1] == -1){
                        //if it is only one row greater than the piece coord
                        //it is a move. The plus one will be -1 for oes
                        if (cList[0][0] == intPieceCoord[0] + 1){
                            board = XMove(board, intPieceCoord, cList);
                            //that's move done
                        }
                        else {
                            board = XJump(board, intPieceCoord, cList);
                            //that's jump down, it works!
                        }
                    }
                    else {
                        board = XMultiJump(board, intPieceCoord, cList);
                        //try multiJump, it works!
                    }
                }
                else {
                    if (cList[1][0] == -1 && cList[1][1] == -1){
                        //if it is only one row greater than the piece coord
                        //it is a move. The plus one will be -1 for oes
                        if (cList[0][0] == intPieceCoord[0] + 1){
                            board = KingMove(board, intPieceCoord, cList, "xk");
                            //that's move done
                        }
                        else {
                            board = KingJump(board, intPieceCoord, cList, "xk");
                            //that's jump down, it works!
                        }
                    }
                    else {
                        board = KingMultiJump(board, intPieceCoord, cList, "xk");
                        //try multiJump, it works!
                    }
                    
                    //String[][] board, int[] pieceCoord,int[][] cList, String symbol
                }
                    
                
                
                
                
                
                turn +=1;
            }
            else if (turn == 1){
                board = KingCheck(board);
                System.out.println("O player, it's your turn.");
                System.out.println("Please enter the coordinate of the piece you want to move.");
                coordinate = sc.next(); 
                intPieceCoord = CoordinateConversion(coordinate);  //this will convert it
                //so it can be used in the grid
                
                //make sure the piece coord is both the right kind and legal
                if (board[intPieceCoord[0]][intPieceCoord[1]].equals("o") || board[intPieceCoord[0]][intPieceCoord[1]].equals("ok")){
                    
                }
                else {
                    System.out.println("Sorry, you entered the wrong coordinate. Try again next time.");
                    System.exit(0);
                }
                
                
                System.out.println("Enter the coordinate of your move or jump spot.");
                subCounter = 0;
                moreToJump = true; //It was set false after the first player's turn
                while (moreToJump == true){
                    
                    System.out.println("If you wish to do a multi-jump, enter where ");
                    System.out.println("the piece will be after the first jump, then");
                    System.out.println("the second, etc. If done, enter DONE."); 
                    coordinate = sc.next();
                    if (!coordinate.equals("DONE")){
                        cList[subCounter] = CoordinateConversion(coordinate);
                    }
                    else {
                        moreToJump = false;
                    }
                    subCounter += 1;
                    
                }
                //this has gotten all we will need from the user
                //now we find out which type of movement they are doing
                
                //if there is only one coordinate in the list
                if (board[intPieceCoord[0]][intPieceCoord[1]].equals("o")){
                    if (cList[1][0] == -1 && cList[1][1] == -1){
                        //if it is only one row greater than the piece coord
                        //it is a move. The plus one will be -1 for oes
                        if (cList[0][0] == intPieceCoord[0] - 1){
                            board = OMove(board, intPieceCoord, cList);
                            //that's move done
                        }
                        else {
                            board = OJump(board, intPieceCoord, cList);
                            //that's jump down, it works!
                        }
                    }
                    else {
                        board = OMultiJump(board, intPieceCoord, cList);
                        //try multiJump, it works!
                    }
                }
                else {
                    if (cList[1][0] == -1 && cList[1][1] == -1){
                        //if it is only one row greater than the piece coord
                        //it is a move. The plus one will be -1 for oes
                        if (cList[0][0] == intPieceCoord[0] - 1){
                            board = KingMove(board, intPieceCoord, cList, "ok");
                            //that's move done
                        }
                        else {
                            board = KingJump(board, intPieceCoord, cList, "ok");
                            //that's jump down, it works!
                        }
                    }
                    else {
                        board = KingMultiJump(board, intPieceCoord, cList, "ok");
                        //try multiJump, it works!
                    }
                }
                    
                
                turn -= 1;
            }
            
        }
        
        
        
        
        
    }
    
}
