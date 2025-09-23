package recursion;
//leetcode 51
//The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
//Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
//
//
//Example 1:
//
//
//Input: n = 4
//Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
//Example 2:
//
//Input: n = 1
//Output: [["Q"]]
//
//
//Constraints:
//
//        1 <= n <= 9

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensProblem {

    // Main function to solve the N-Queens problem
    public static List<List<String>> solveNQueens(int n) {
        // 1️⃣ Create an n x n chessboard initialized with '.'
        // '.' represents an empty cell, 'Q' will represent a queen
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // 2️⃣ List to store all valid solutions
        List<List<String>> ans = new ArrayList<>();

        // 3️⃣ Start backtracking from the first row (row 0)
        backtrack(0, board, ans, n);

        // 4️⃣ Return all possible solutions
        return ans;
    }

    // Backtracking function to try placing queens row by row
    public static void backtrack(int row, char[][] board, List<List<String>> ans, int n) {
        // Base case: If we have placed queens in all rows
        if (row == n) {
            // Convert the board to a list of strings and add it to results
            ans.add(construct(board));
            return;
        }

        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {
            // Check if it is safe to place a queen at (row, col)
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';                 // Place the queen
                backtrack(row + 1, board, ans, n);    // Recurse for next row
                board[row][col] = '.';                 // Backtrack: remove the queen
            }
        }
    }

    // Function to check if it is safe to place a queen at (row, col)
    public static boolean isSafe(int row, int col, char[][] board, int n) {
        int r, c;

        // 1️⃣ Check the column above
        r = row - 1; // Start from the row above
        while (r >= 0) {
            if (board[r][col] == 'Q') return false; // Another queen in the same column
            r--; // Move upward
        }

        // 2️⃣ Check the upper-left diagonal ↖
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false; // Another queen in the upper-left diagonal
            r--;
            c--; // Move up-left
        }

        // 3️⃣ Check the upper-right diagonal ↗
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') return false; // Another queen in the upper-right diagonal
            r--;
            c++; // Move up-right
        }

        // If no conflicts, it is safe to place a queen
        return true;
    }

    // Function to convert the board into a list of strings for storing in results
    public static List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row)); // Convert each row to a string
        }
        return list;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(7); // Example: n = 7
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row); // Print each row of the board
            }
            System.out.println(); // Separate different solutions
        }
    }
}

