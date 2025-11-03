package dynamicProgramming;
//Maximum path sum gfg
//You are given a matrix mat[][] of size n x m where each element is a positive integer. Starting from any cell in the first row, you are allowed to move to the next row, but with specific movement constraints. From any cell (r, c) in the current row, you can move to any of the three possible positions :
//
//        (r+1, c-1) — move diagonally to the left.
//        (r+1, c) — move directly down.
//        (r+1, c+1) — move diagonally to the right.
//Find the maximum sum of any path starting from any column in the first row and ending at any column in the last row, following the above movement constraints.
//
//Examples :
//
//Input: mat[][] = [[3, 6, 1], [2, 3, 4], [5, 5, 1]]
//Output: 15
//Explaination: The best path is (0, 1) -> (1, 2) -> (2, 1). It gives the maximum sum as 15.
//Input: mat[][] = [[2, 1, 1], [1, 2, 2]]
//Output: 4
//Explaination: The best path is (0, 0) -> (1, 1). It gives the maximum sum as 4.
//Input: mat[][] = [[25]]
//Output: 25
//Explaination: (0, 0) is the only cell in mat[][], so maximum path sum will be 25.
//Constraints:
//        1 ≤ mat.size() ≤ 500
//        1 ≤ mat[i].size() ≤ 500
//        1 ≤ mat[i][j] ≤ 1000

public class MaximumPath {
    public static int maximumPath(int[][] mat) {
        // code here
        int m=mat.length;
        int n=mat[0].length;
        if(m==1 && n==1) return mat[0][0];

        int dp[][]=new int[m][n];
        for(int j=0;j<n;j++){
            dp[0][j]=mat[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int up = dp[i - 1][j];
                int leftDiag = (j > 0) ? dp[i - 1][j - 1] : 0;
                int rightDiag = (j < n - 1) ? dp[i - 1][j + 1] : 0;

                dp[i][j] = mat[i][j] + Math.max(up, Math.max(leftDiag, rightDiag));
            }
        }
        int maxSum=dp[m-1][0];
        for(int i=1;i<n;i++){
            maxSum=Math.max(maxSum,dp[m-1][i]);
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int n=5;
        int m=1;
        int[][] mat={
            {4},
            {7},
            {7},
                {8},
                {8}

        };
        System.out.println(maximumPath(mat));

    }
}
