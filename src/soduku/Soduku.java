/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soduku;

/**
 *
 * @author Nabuletion
 */
public class Soduku {

    /**
     * @param args the command line arguments
     */
    private static final int GRID = 9;
    
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] board = {
            {7, 0, 2, 0, 5, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0},
            {1, 0, 0, 0, 0, 9, 5, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 9, 0},
            {0, 4, 3, 0, 0, 0, 7, 5, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 8},
            {0, 0, 9, 0, 7, 0, 0, 0, 5},
            {0, 0, 0, 2, 0, 0, 0, 0, 0},
            {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        
        printBoard(board);
        System.out.println(solveSuduku(board));
        
//        printBoard(board);
        
    }
    
    private static void printBoard(int[][] board){
        for(int row = 0; row < GRID; row++){
            for(int col = 0; col < GRID; col++){
                System.out.print(board[row][col]);
            }
            System.out.println("");
        }
    }
    
    //    checking row
    private static boolean inRow(int[][] board, int number, int row){
        for(int i = 0; i < GRID; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }
    
    //    checking column
    private static boolean inColumn(int[][] board, int number, int col){
        for(int i = 0; i < GRID; i++){
            if(board[i][col] == number){
                return true;
            }
        }
        return false;
    }
    
    //  box check
    private static boolean inBox(int[][] board, int number, int row, int col){
        int grid_row = row -row % 3;
        int grid_column = col - col % 3;
        
        for(int x = 0; x < grid_row + 3; x++){
            for(int y = 0; y < grid_column + 3; y++){
                if(board[x][y] == number){
                    return true;
                }
            }
        }
        return false;
    }
    // checking all
    public static boolean validPosition(int[][] board, int number, int row, int col){
        return !inRow(board, number, row) && !inColumn(board, number, col) && !inBox(board, number, row, col);
    }
    private static boolean solveSuduku(int [][] board){
        for(int row = 0; row < GRID; row++){
            for(int col = 0; col < GRID; col++){
                if(board[row][col] == 0){
                    for(int number = 1; number <= 9; number++){
                        if(validPosition(board, number, row, col)){
                            board[row][col] = number;
                            
                            if(solveSuduku(board)){
                                return true;
                            }else{
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
