package cwh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * 제목: 행렬 곱셈 순서
 * 링크: https://www.acmicpc.net/problem/11049
 * 해설:
 * 점화식
 * 1. MIN(dp[start][mid] + 나머지 계산, dp[mid][end] + 나머지 계산)
 *
 */

public class Quiz11049 {
    static int N;
    static int[][] matrixs = new int[501][2];
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            String[] datas = br.readLine().split(" ");

            matrixs[i][0] = Integer.parseInt(datas[0]);
            matrixs[i][1] = Integer.parseInt(datas[1]);
        }


        System.out.println(solve(1, N));
    }

    static int solve(int start, int end) {
//        System.out.println("start: " + start + " end: " + end);

        if(start == end) return 0; // 같을 경우 빠져나옴
        if(dp[start][end] != 0) return dp[start][end];

        dp[start][end] = Integer.MAX_VALUE;

        for(int i = start; i < end; i++) {
            dp[start][end] = Math.min(dp[start][end], solve(start, i) + solve(i+1, end)
                    + (matrixs[start][0] * matrixs[i][1] * matrixs[end][1]));
//            for(int k = 1 ; k <= N; k++) {
//                for(int j = 1; j <= N; j++) {
//                    System.out.print(dp[k][j] + " ");
//                }
//                System.out.println();
//            }
        }

        return dp[start][end];
    }
}