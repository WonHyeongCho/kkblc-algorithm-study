package com.company.baek.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz14501_dp {
    static int N ;
    static int T[];
    static int P[];

    static int dp[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N+1];
        P = new int[N+1];

        dp = new int[N+2];

        String tmpStrArr[] = new String[2];

        for (int i = 1; i <= N; i++) {
            tmpStrArr = br.readLine().split(" ");
            T[i] = Integer.parseInt(tmpStrArr[0]);
            P[i] = Integer.parseInt(tmpStrArr[1]);

        }

        int max = 0;
        for (int i = N; i >=1 ; i--) {
            if(i+T[i] <= N+1){
                dp[i] = Math.max(P[i]+dp[i+T[i]],dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }

        }
        System.out.println(dp[1]);
    }


    public static void print2(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();

    }
    public static int getMax(int arr[]){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }

}
