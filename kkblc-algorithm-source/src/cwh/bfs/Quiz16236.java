package cwh.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 링크: https://www.acmicpc.net/problem/16236
 * 제목: 아기 상어
 * 예외: 1. 사이즈가 9보다 클 경우, 2. 위부터 보고 왼쪽, 3. 다 찾고 한번 더 돌면 시간 초과
 */

public class Quiz16236 {
    static int N;
    static int[][] map = new int[21][21]; // 지도
    static int[] dx = {0, -1, 1, 0}; // 북 서 동 남 --> 위, 왼쪽부터 찾기 위해
    static int[] dy = {-1, 0, 0, 1}; // 북 서 동 남

    static Shark babyShark;
    static int result = 0;

    static int minDistance; // 최소 거리
    static int minX;
    static int minY;

    static int fishCount = 0; // 물고기 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 초기화
        N = sc.nextInt();

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                map[i][j] = sc.nextInt();

                if(map[i][j] == 9) {
                    babyShark = new Shark(j, i);
                }
                else if(map[i][j] > 0) fishCount++;
            }
        }

        while(true) {
            if(fishCount == 0) break;

            if(!bfs()) { // 다 먹거나 먹을 게 없는 경우
                break;
            }
            else { // 한 싸이클이 끝난 경우
                map[babyShark.y][babyShark.x] = 0; // 이전 상어위치 0으로 변경
                babyShark.x = minX;
                babyShark.y = minY;
                map[minY][minX] = 9; // 위치 변경
                babyShark.eatCount += 1;

                if(babyShark.eatCount == babyShark.size) { // 먹은 횟수가 자기 크기랑 같은 경우
                    babyShark.eatCount = 0;
                    babyShark.size += 1;
                }
//                System.out.println("minX: " + minX + ", minY: " + minY + ", minD: " + minDistance);
                fishCount--;
                result += minDistance;
            }

//            for(int i = 1; i < N+1; i++) {
//                for(int j = 1; j < N+1; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        System.out.print(result);
    }

    static boolean bfs() {
        minDistance = 10000; // 최단 거리 초기화
        minX = 10000;
        minY = 10000;

        int[][] visited = new int[21][21]; // 최단 거리를 찾기 위해 visited
        Queue<int[]> queue = new LinkedList<>(); // x, y distance 표시
        queue.add(new int[]{babyShark.x, babyShark.y, 0});
        visited[babyShark.y][babyShark.x] = 1;
//        System.out.println(result);

        while(!queue.isEmpty()) {
            int[] curLocation = queue.poll();
//            System.out.println("x: " + curLocation[0] + ", y: " + curLocation[1] + ", d: " + curLocation[2] + ", size: " + babyShark.size);

            if(curLocation[2] > minDistance) {
                return true;
            }

            if(map[curLocation[1]][curLocation[0]] != 0 && map[curLocation[1]][curLocation[0]] != 9 && map[curLocation[1]][curLocation[0]] < babyShark.size) { // 자기보다 작은 물고기를 찾음
                minDistance = curLocation[2];

                if(minY == curLocation[1]) { // 검사
                    if(minX > curLocation[0]) {
                        minX = curLocation[0];
                    }
                }
                else if(minY > curLocation[1]) { // 위인지 검사
                    minX = curLocation[0];
                    minY = curLocation[1];
                }
            }

            for(int i = 0; i < 4; i++) {
                int nextX = curLocation[0] + dx[i];
                int nextY = curLocation[1] + dy[i];

                if(nextX > 0 && nextX < N+1 && nextY > 0 && nextY < N+1) { // 밖으로 넘어가지 않은 경우
                    if(visited[nextY][nextX] == 0 && map[nextY][nextX] <= babyShark.size) { // 방문 안 하고 사이즈가 작거나 같을 경우
                        visited[nextY][nextX] = 1;
                        queue.add(new int[]{nextX, nextY, curLocation[2]+1});
                    }
                }
            }
        }

        if(minDistance != 10000) { // 큐가 다 비어있지만 최소를 찾은 겨웅
            return true;
        }

        return false;
    }
}

class Shark {
    int x;
    int y;
    int size;
    int eatCount;

    Shark(int x, int y) {
        this.size = 2;
        this.x = x;
        this.y = y;
        eatCount = 0;
    }
}