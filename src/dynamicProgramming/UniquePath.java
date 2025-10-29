package dynamicProgramming;
//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//The test cases are generated so that the answer will be less than or equal to 2 * 109.
//Input: m = 3, n = 7
//Output: 28
//Example 2:
//
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//        1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down

public class UniquePath {
    public static int countUnique(int m,int n){
        int dp[][] =new int[m][n];
       return solve(0,0,m,n,dp);

    }
    public static int solve(int row,int col,int m,int n,int[][] dp){
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(row>=m || col>=n) return 0;

        if(dp[row][col]!=0) return dp[row][col];

        int right=solve(row,col+1,m,n,dp);
        int down=solve(row+1,col,m,n,dp);

        return dp[row][col]=right+down;

    }
    public static void main(String[] args) {
        System.out.println(countUnique(3,7));

    }
}
//🔍 What does dp[row][col] store?
//
//        👉 It stores the number of unique paths from cell (row, col) to the destination (m, n)
//        (in memoized recursion version)
//or
//👉 It stores the number of unique paths from the start (1,1) to cell (row, col)
//        (in tabulation version).
//
//        📌 The meaning of dp[row][col] depends on whether you’re doing top-down (recursion + memo) or bottom-up (iterative tabulation).
