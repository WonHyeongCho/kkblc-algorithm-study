package cwh.dp;

import java.util.Scanner;

public class Quiz11055 {
    static int N;
    static int[] array = new int[1001];
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int N = sc.nextInt();

        for(int i = 1; i < N+1; i++) {
            int number = sc.nextInt();
            array[i] = number;
            dp[i] = number;
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < i; j++) {
                if(array[j] < array[i] && dp[i] < dp[j] + array[i])
                    dp[i] = dp[j] + array[i];
            }

            if(dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }
}
