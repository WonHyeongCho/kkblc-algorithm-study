package cwh.dp;

/*
 * 제목: 파일 합치기
 * 링크: https://www.acmicpc.net/problem/11066
 * 해설: 이거 어디서 풀어봤는뎅... dp에 뭘 저장해야 하지???
 * 40 30 30 50
 * answer[0] = 40
 * answer[1] = 70
 * answer[2] = 160
 * answer[3] = 300
 * 점화식X
 *
 * dp[i][j] --> i부터 j까지 더하는 장의 최소값을 저장하는 dp
 *
 * 3중 for 문
 * 첫 번째: start 와 end 의 distance --> 1칸 2칸 3칸 ...
 * 두 번째: start 와 end 를 정해줌
 * 세 번째: 값을 채움
 * 포문돌면서 dp[][] 값을 채워감
 * 점화식은 --> dp[i][j] = min(dp[i][mid] + dp[mid][j]) --> mid는 i+1 ~ j-1 + 전체 sum
 *
 * https://js1jj2sk3.tistory.com/3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz11066 {
    static int T;
    static int K;
    static int[] numbers = new int[501];
    static int[][] dp = new int[501][501];
    static int[] sums = new int[501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            String[] dataArray = br.readLine().split(" ");

            for(int j = 1; j <= K; j++) {
                numbers[j] = Integer.parseInt(dataArray[j-1]);
            }

            for(int index = 1; index <= K; index++) {
                sums[index] = sums[index-1] + numbers[index];
            }

            for(int d = 1; d <= K; d++) { // distance
                for(int start = 1; start + d <= K; start++) { // 시작 지점
                    int end = start + d;
                    dp[start][end] = Integer.MAX_VALUE; // 최대값 넣기

                    for(int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][mid] + dp[mid+1][end] + sums[end] - sums[start-1], dp[start][end]);

//                        for(int row = 1; row <= K; row++) {
//                            for(int col = 1; col <= K; col++) {
//                                System.out.print(dp[row][col] + " ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println();
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
    }
}
