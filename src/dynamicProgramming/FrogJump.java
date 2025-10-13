package dynamicProgramming;

import java.util.Arrays;

//🐸 Problem Description — Frog Jump with K Distance
//🔹 Problem Statement
//
//There are N stones placed in a line, numbered from 0 to N-1.
//Each stone has a certain height given in an integer array height[],
//where height[i] represents the height of the iᵗʰ stone.
//
//A frog is initially on stone 0.
//From a stone at index i, the frog can jump to any stone j such that:
//
//i < j ≤ i + K
//
//
//— i.e., it can jump up to K stones ahead in a single move.
//
//The cost of jumping from stone i to stone j is:
//
//        |height[i] - height[j]|
//
//
//        (the absolute difference between their heights).
//
//Your task is to find the minimum total cost required for the frog to reach the last stone (N - 1).
//
//        🔹 Input Format
//
//An integer array height[] of length N, where N ≥ 1.
//
//An integer K representing the maximum number of stones the frog can jump over in one move.
//
//🔹 Output Format
//
//Return a single integer — the minimum total cost to reach the last stone.
//
//🔹 Constraints
//1 ≤ N ≤ 10^5
//        1 ≤ height[i] ≤ 10^4
//        1 ≤ K ≤ 100
//
//        🔹 Examples
//✅ Example 1
//Input:
//height = [10, 30, 40, 20]
//k = 2
//
//Output:
//        30
//
//
//Explanation:
//
//Path: 0 → 1 → 3
//Cost = |30−10| + |20−30| = 20 + 10 = 30

public class FrogJump {

    public static int minCost(int[] height,int k){
        int n= height.length;
        if (n == 1) return 0; // no cost to stay at first stone
        if (n == 2) return Math.abs(height[1] - height[0]); // cost of one jump

        int[] minCost=new int[n];
        Arrays.fill(minCost,Integer.MAX_VALUE);
        minCost[0]=0;
//        minCost[1]=Math.abs(height[1]-height[0]);
        for(int i=1;i<n;i++){
            for(int j=1;j<=k && i-j>=0;j++){
                int jump=minCost[i-j]+Math.abs(height[i]-height[i-j]);
                minCost[i]=Math.min(minCost[i],jump);
            }

        }
        return minCost[n-1];
    }
    public static void main(String[] args) {
        int[] height={10, 20, 30, 40, 50};
        System.out.println(minCost(height,3));

    }


}
