package cwh.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Quiz2178 {
    static int N;
    static int M;
    static int[][] map = new int[101][101];
    static int[][] visited = new int[101][101];

    static int[] dx = {1, 0, -1, 0}; // 동 남 서 북
    static int[] dy = {0, 1, 0, -1}; // 동 남 서 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();
        N = Integer.parseInt(data.split(" ")[0]);
        M = Integer.parseInt(data.split(" ")[1]);

        for(int i = 1; i < N+1; i++) {
            data = br.readLine();
            for(int j = 1; j < M+1; j++) {
                String[] splitData = data.split("");
                map[i][j] = Integer.parseInt(splitData[j-1]);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>(); // 1차원 배열로 x, y, 거리 표시
        queue.add(new int[]{1, 1, 1}); // 시작 위치 포함
        map[1][1] = 1;

        while(!queue.isEmpty()) {
            int[] curLocation = queue.poll();

            if(curLocation[0] == M && curLocation[1] == N) {
                return curLocation[2];
            }

            for(int i = 0; i < 4; i++) {
                int nextX = curLocation[0] + dx[i];
                int nextY = curLocation[1] + dy[i];

                if(nextX > 0 && nextX < M+1 && nextY > 0 && nextY < N +1){ //밖으로 안나가면, 지나갈 수 있으면
                    if(map[nextY][nextX] == 1 && visited[nextY][nextX] == 0) {
                        queue.add(new int[]{nextX, nextY, curLocation[2]+1});
                        visited[nextY][nextX] = 1;
                    }
                }
            }
        }

        return 0;
    }
}
