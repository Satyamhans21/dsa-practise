package recursion;
//37. Sudoku Solver
//Solved
//        Hard
//Topics
//premium lock icon
//        Companies
//Hint
//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//A sudoku solution must satisfy all of the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.
//
//
//
//Example 1:
//
//
//Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
//Explanation: The input board is shown above and the only valid solution is shown below:
//
//
//
//
//Constraints:
//
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit or '.'.
//It is guaranteed that the input board has only one solution.

public class SodukoSolver {

    // Entry point to solve the Sudoku
    public static void solve(char[][] board){
        backtrack(board); // Start backtracking from the first empty cell
    }

    // Backtracking function: tries to fill empty cells
    public static boolean backtrack(char[][] board){
        // Iterate through all rows
        for(int row = 0; row < 9; row++){
            // Iterate through all columns
            for(int col = 0; col < 9; col++){
                // If current cell is empty
                if (board[row][col] == '.'){
                    // Try placing digits '1' to '9'
                    for(char c = '1'; c <= '9'; c++){
                        // Check if placing 'c' is valid
                        if(isValid(row, col, board, c)){
                            board[row][col] = c; // Place the digit

                            // Recursively try to fill the rest of the board
                            if(backtrack(board)) return true;

                            // Backtrack: reset the cell if it leads to no solution
                            board[row][col] = '.';
                        }
                    }
                    // If no valid digit can be placed, return false
                    return false;
                }
            }
        }
        // If all cells are filled successfully
        return true;
    }

    // Check if placing digit 'c' at (row, col) is valid
    public static boolean isValid(int row, int col, char[][] board, char c){
        for(int i = 0; i < 9; i++){
            // Check row: no duplicate
            if(board[row][i] == c) return false;

            // Check column: no duplicate
            if(board[i][col] == c) return false;

            // Check 3x3 subgrid
            int subRow = (row / 3) * 3 + i / 3; // Calculate row index inside subgrid
            int subCol = (col / 3) * 3 + i % 3; // Calculate column index inside subgrid
            if(board[subRow][subCol] == c) return false;
        }
        return true; // Safe to place 'c'
    }

    // Utility function to print the Sudoku board
    public static void printBoard(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Input Sudoku board (empty cells are '.')
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        // Solve the Sudoku
        solve(board);

        // Print the solved board
        printBoard(board);
    }
}

