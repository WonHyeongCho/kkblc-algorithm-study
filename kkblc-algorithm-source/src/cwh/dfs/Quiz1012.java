package cwh.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz1012 {
    static int T; // 테스트 케이스
    static int M; // 가로 길이
    static int N; // 세로 길이
    static int K; // 배추 개수

    static int[][] map; // 배추 지도
    static int[][] check; // 방문 확인
    static int[] dx = {0, 1, 0, -1}; //  동 북 서
    static int[] dy = {1, 0, -1, 0}; // 남 동 북 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String next = br.readLine();
            M = Integer.parseInt(next.split(" ")[0]); // 가로 길이
            N = Integer.parseInt(next.split(" ")[1]); // 세로 길이
            K = Integer.parseInt(next.split(" ")[2]); // 배추 개수

            map = new int[N][M];
            check = new int[N][M];

            for(int j = 0; j < K; j++) {
                String cabbage = br.readLine();
                int x = Integer.parseInt(cabbage.split(" ")[0]);
                int y = Integer.parseInt(cabbage.split(" ")[1]);
                map[y][x] = 1;
            }
            /*
            for(int a = 0; a < N; a++) { // 세로
                for(int b = 0; b < M; b++) { // 가로
                    System.out.print(map[a][b]);
                }
                System.out.println();
            }
            */
            int count = 0;

            for(int a = 0; a < N; a++) { // 세로
                for(int b = 0; b < M; b++) { // 가로
                    if(map[a][b] == 1 && check[a][b] == 0) { // 땅에 배추가 있고, 방문하지 않았을 경우
//                        System.out.println("들어감");
                        dfs(b, a);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
//        System.out.println("(" + y + "," + x + ")");
        check[y][x] = 1;

        for(int i = 0; i < 4; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
//            System.out.println("다음 위치: (" + nextY + "," + nextX + ")");
            if(nextX > -1 && nextX < M && nextY > -1 && nextY < N) { // 지도 밖으로 나가는 경우
//                System.out.println("다음 map: " + map[nextY][nextX]);
//                System.out.println("다음 check: " + check[nextY][nextX]);
                if(map[nextY][nextX] == 1 && check[nextY][nextX] == 0){ // 배추 위치이고 방문 X
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
