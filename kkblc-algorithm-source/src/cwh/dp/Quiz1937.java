package cwh.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 제목: 욕심쟁이 판다
 * 링크: https://www.acmicpc.net/problem/1937
 * 해설: dfs 돌리면서 값이 있으면 dp + 1 그런데 81번째 라인 하려면 속도 줄이려고 하는데
 * 왜 에러가 날까??
 */

public class Quiz1937 {
    static int n;
    static int[][] map = new int[500][500];
    static int[][] dp = new int[500][500];
    static int[] dx = {1, -1, 0, 0}; // 동 서 남 북
    static int[] dy = {0, 0, 1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String data = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(data.split(" ")[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                solve(j, i);
//                System.out.println("Next Solve Method");
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] > answer) answer = dp[i][j];
            }
        }

        System.out.println(answer);
    }

    static void solve(int x, int y) { // dfs로 전체 찾는다.
        int current = map[y][x];

//        System.out.println("x: " + x + ", y: " + y + ", current: " + current);
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for(int i = 0; i < 4; i++) { // 4 방향으로 dfs
            int nextX = x + dx[i]; // {1, -1, 0, 0}
            int nextY = y + dy[i]; // {0, 0, 1, -1}

            if(nextX > -1 && nextX < n && nextY > -1 && nextY < n) { // 테두리 검사
                if(map[nextY][nextX] > current) {
                    if(dp[nextY][nextX] > 0) { // 이미 값이 있다면
                        dp[y][x] = Math.max(dp[y][x], dp[nextY][nextX] + 1);
                    }
                    else {
                        solve(nextX, nextY);
                        dp[y][x] = Math.max(dp[y][x], dp[nextY][nextX] + 1);
                    }
//                    if(dp[nextY][nextY] == 0) {
//                        solve(nextX, nextY);
//                    }
//                    dp[y][x] = Math.max(dp[y][x], dp[nextY][nextX] + 1);
                }
            }
        }
//        if(dp[y][x] == 0) dp[y][x] = 1; --> 이거 하면 틀림 왜일까??
    }
}
