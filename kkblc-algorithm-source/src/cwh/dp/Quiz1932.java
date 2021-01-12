package cwh.dp;

import java.util.Scanner;

public class Quiz1932 {
    static int N;
    static int[][] triangle = new int[501][501];
    static int[][] dp = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int result = 0;

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < i+1; j++) {
                int number = sc.nextInt();
                triangle[i][j] = number;
                dp[i][j] = number;
            }
        }

        for(int i = 2; i < N+1; i++) {
            for(int j = 1; j < i+1; j++) {
                if(j == 1) { // 제일 처음
                    dp[i][j] += dp[i-1][j];
                }
                else if(j == i) { // 제일 마지막
                    dp[i][j] += dp[i-1][j-1];
                }
                else { // 중간
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

//        for(int i = 1; i < N +1; i++) {
//            for(int j = 1; j < i+1; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i = 1; i < N+1; i++) {
            if(dp[N][i] > result) result = dp[N][i];
        }

        System.out.println(result);
    }
}