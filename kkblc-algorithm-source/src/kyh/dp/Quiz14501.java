package com.company.baek.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz14501 {
    static int N;
    static int arr[][];
    static int max = 0;
    static int dpArr[];
//    static int sum = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dpArr = new int[N];

        String temp[] = new String[2];
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }
        for (int i = 0; i < N; i++) {

            max = 0;
            dpArr[i] = dp(i,0);

//            dp(i,0);
        }
        System.out.print(getMax(dpArr));
//        System.out.print(max);

//        print2(dpArr);
    }

////    static int sum = 0;
//    public static void dp(int i, int sum){
//        if (i + 1 > N || i + arr[i][0] > N) return;
//
//        sum += arr[i][1];
////        dpArr[i] += arr[i][1];
//        if(max < sum) max = sum;
//
////        System.out.println(max+"/"+(i+1) + " / "+arr[i][0]);
//
//
//
//        for (int j = i+arr[i][0]; j < N; j++) {
//             dp(j, sum);
//        }
//
//    }

    public static int dp(int i, int sum){
        if (i + 1 > N || i + arr[i][0] > N) return 0;

        sum += arr[i][1];

//        if(max < sum) max = sum;
        int tempSum = 0;
        for (int j = i+arr[i][0]; j < N; j++) {
//            if(temp < sum + dp(j,sum)) max = sum + dp(j,sum);
            if(tempSum < dp(j,sum)) tempSum = dp(j,sum);
        }

        sum += tempSum;
        if(max < sum ) max = sum;

        return max;
    }

    public static int getMax(int arr[]){
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) max = arr[i];
        }
        return max;
    }

    public static void print(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void print2(int arr[]){
        for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+ " ");
        }
        System.out.println();

    }
}
