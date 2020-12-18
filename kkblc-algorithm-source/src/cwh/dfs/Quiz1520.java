package cwh.dfs;

/*
 * 링크: https://www.acmicpc.net/problem/1520
 * 제목: 내리막 길
 */

import java.util.Scanner;

public class Quiz1520 {

    static int M; // 세로 길이
    static int N; // 가로 길이
    static int[] dx = {0, 1, 0, -1}; // 남 동 북 서
    static int[] dy = {1, 0, -1, 0}; // 남 동 북 서

    static int[][] map = new int[501][501]; // 지도
    static int[][] memo = new int[501][501]; // 메모

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt(); // 세로 길이
        N = sc.nextInt(); // 가로 길이

        for(int i = 1; i < M+1; i++) {
            for(int j = 1; j < N+1; j++) {
                map[i][j] = sc.nextInt();
                memo[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    static int dfs(int x, int y) {
        if(x == N && y == M) { // 끝에 도달했을 경우
            return 1;
        }

        if(memo[y][x] == -1) { // 방문한 적이 없고 경로 계산 한 적이 없는 경우
            memo[y][x] = 0;

            for(int i = 0; i < 4; i++) {
                int nextX = x+dx[i];
                int nextY = y+dy[i];

                if(nextX > 0 && nextX < N+1 && nextY > 0 && nextY < M+1) { // 지도 밖으로 안넘어 갈 떄
                    if(map[nextY][nextX] < map[y][x]) { // 현재 값보다 작을 경우
                        memo[y][x] += dfs(nextX, nextY);
                    }
                }
            }
        }

        return memo[y][x];
    }
}
