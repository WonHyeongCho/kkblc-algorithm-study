package cwh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz14501 {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 변수 받기
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String data = br.readLine();
            T[i] = Integer.parseInt(data.split(" ")[0]);
            P[i] = Integer.parseInt(data.split(" ")[1]);

            dp[i] = P[i];
        }

        for(int i = 2; i < N+1; i++) {
            for(int j = 1; j < i; j++) {
                if(i - j >= T[j]) {
                    dp[i] = Math.max(P[i] + dp[j], dp[i]);
                }
            }
        }

        int max = 0;

        for(int i = 1; i < N+1; i++) {
            if(i + T[i] <= N+1) {
                if(max < dp[i]) {
                    max = dp[i];
                }
            }
        }

        System.out.println(max);
    }
}
