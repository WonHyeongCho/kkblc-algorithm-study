package cwh.bfs;

/*
 * 링크: https://www.acmicpc.net/problem/4179
 * 제목: 불!
 * 예외:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Quiz4179 {
    static int R, C;
    static char[][] map;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static Queue<int[]> jihunQueue = new LinkedList<>(); // 지훈이 큐
    static Queue<int[]> fireQueue = new LinkedList<>(); // 불 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();

        R = Integer.parseInt(data.split(" ")[0]); // 행
        C = Integer.parseInt(data.split(" ")[1]); // 열

        map = new char[R+2][C+2];

        for(int i = 1; i < R+1; i++) {
            data = br.readLine();
            for(int j = 1; j < C+1; j++) {
                map[i][j] = data.charAt(j-1);

                if(data.charAt(j-1) == 'J') jihunQueue.add(new int[]{j, i}); // 행 열 삽입(y, x)
                else if(data.charAt(j-1) == 'F') fireQueue.add(new int[]{j, i});
            }
        }

        int minute = 1;

        while(true) { // bfs
            minute++;
            int nextX;
            int nextY;

            int fireQueueSize = fireQueue.size();
            while(fireQueueSize-- > 0) { // 불 먼저
                 int[] fire = fireQueue.poll();

                 for(int i = 0; i < 4; i++) {
                     nextX = fire[1] + dx[i];
                     nextY = fire[0] + dy[i];

                     if(map[nextY][nextX] != '#') {
                         map[nextY][nextX] = 'F';
                         fireQueue.add(new int[]{nextY, nextX});
                     }
                 }
            }

            int jihunQueueSize = jihunQueue.size();
            while(jihunQueueSize-- > 0) { // 지훈이
                int[] jihun = jihunQueue.poll();

                for(int i = 0; i < 4; i++) {
                    nextX = jihun[1] + dx[i];
                    nextY = jihun[0] + dy[i];

                    if(nextX == 0 || nextX == R+1 || nextY == 0 || nextY == C) { // 탈출
                        System.out.println(minute);
                        return;
                    }

                    if(map[nextY][nextX] == '.') {
                        map[nextY][nextX] = 'J';
                        jihunQueue.add(new int[]{nextY, nextX});
                    }
                }
            }

            if(jihunQueue.isEmpty()) {
                break;
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
