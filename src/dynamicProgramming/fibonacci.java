package dynamicProgramming;

import java.util.Arrays;

public class fibonacci {
    public static int fibo(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibo(n-1,dp)+fibo(n-2,dp);
    }

    public static int fiboTabulation(int n){
        if(n<=1) return n;

        int dp[] =new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {

        int n=10;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        fibo(n,dp);
        System.out.println(dp[n]);

        System.out.println(fiboTabulation(n));

    }
}
