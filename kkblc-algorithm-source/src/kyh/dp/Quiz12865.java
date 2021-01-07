package com.company.baek.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz12865 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tmpStr[] = new String[2];
        tmpStr = br.readLine().split(" ");
        int N = Integer.parseInt(tmpStr[0]);
        int K = Integer.parseInt(tmpStr[1]);

        int W[] = new int[N+1]; //가중치
        int V[] = new int[N+1]; //가치
        int dp[][] = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            tmpStr = br.readLine().split(" ");
            W[i] = Integer.parseInt(tmpStr[0]);
            V[i] = Integer.parseInt(tmpStr[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(W[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j],V[i] + dp[i-1][j-W[i]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[N][K]);
//        print(dp);

    }

    public static void print(int a[][]){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
