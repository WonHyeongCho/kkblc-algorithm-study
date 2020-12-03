package cwh.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 링크: https://www.acmicpc.net/problem/3190
 * 제목: 뱀
 */

public class Quiz3190 {
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0};
    static int N, d;
    static int[][] map; // 지도
    static Queue<DirectionInfo> directionInfoQueue;
    static List<Snake> snakeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 지도 크기
        map = new int[N+2][N+2]; // 지도
        d = 0; // 방향 인덱스

        int appleCount = Integer.parseInt(br.readLine()); // 사과 개수
        for(int i = 0; i < appleCount; i++) { // 사과 위치 초기화
            String apple = br.readLine();
            map[Integer.parseInt(apple.split(" ")[0])][Integer.parseInt(apple.split(" ")[1])] = 1;
        }

        int directionCount = Integer.parseInt(br.readLine()); // 방향 지시 개수
        directionInfoQueue = new LinkedList<>();

        for(int i = 0; i < directionCount; i++) {
            String direction = br.readLine();
            directionInfoQueue.add(new DirectionInfo(Integer.parseInt(direction.split(" ")[0]), direction.split(" ")[1]));
        }

        snakeList = new ArrayList<>();
        snakeList.add(new Snake(1, 1));

        // 여기까지 변수 초기화 완료

        System.out.println(solution());
    }

    static int solution() { // 문제 해결
        int time = 0;
        DirectionInfo directionInfo = directionInfoQueue.poll();

        while(true) {
            Snake snakeHead = snakeList.get(0);
            int nextSnakeHeadX = snakeHead.x + dx[d];
            int nextSnakeHeadY = snakeHead.y + dy[d];
            time++;

            if(checkWall(nextSnakeHeadX, nextSnakeHeadY)){
                return time;
            }

            if(map[nextSnakeHeadX][nextSnakeHeadY] != 1) { // 사과가 아닐 경우
                snakeList.remove(snakeList.size()-1); // 꼬리 없애기
            }
            snakeList.add(0, new Snake(nextSnakeHeadX, nextSnakeHeadY));

            if(checkSnakeBody(nextSnakeHeadX, nextSnakeHeadY)){
                return time;
            }

            if(directionInfo != null) {
                if(time == directionInfo.seconds) {
                    directionInfo = directionInfoQueue.poll();
                    changeDirection(directionInfo);
                }
            }
        }
    }

    static void changeDirection(DirectionInfo directionInfo) { // 방향 변경
        if(directionInfo.direction.equals("D")) {
            d = (d+1)%4;
        }
        else if (directionInfo.direction.equals("L")) {
            d = (d-1)%4;
            if(d == -1) {
                d = 3;
            }
        }
    }

    static boolean checkWall(int nextSnakeHeadX, int nextSnakeHeadY) { // 벽 부딫쳤는지
        return nextSnakeHeadX == 0 || nextSnakeHeadX == N + 1 || nextSnakeHeadY == 0 || nextSnakeHeadY == N + 1; // 벽 체크
    }

    static boolean checkSnakeBody(int nextSnakeHeadX, int nextSnakeHeadY) {
        for (Snake snake : snakeList) { // 뱀 몸통 체크
            if (nextSnakeHeadX == snake.x && nextSnakeHeadY == snake.y) {
                return true;
            }
        }
        return false;
    }

    static class DirectionInfo {
        int seconds;
        String direction;
        DirectionInfo(int seconds, String direction) {
            this.seconds = seconds;
            this.direction = direction;
        }
    }

    static class Snake {
        int x;
        int y;
        Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*
public class Quiz3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 0, -1, 1}; // 동 서 북 남
        int[] dy = {1, -1, 0, 0};
        int[][] map;

        int N = Integer.parseInt(br.readLine());

        map = new int[N+2][N+2]; // 벽 때문에 +2

        int appleCount = Integer.parseInt(br.readLine()); // 사과 개수

        for(int i = 0; i < appleCount; i++) { // 사과 위치 초기화
            String point = br.readLine();
            map[Integer.parseInt(point.split(" ")[0])][Integer.parseInt(point.split(" ")[1])] = 1;
        }

        int planCount = Integer.parseInt(br.readLine()); // 플랫 개수

        Queue<Plan> planQueue = new LinkedList<>();

        for(int i = 0; i < planCount; i++) {
            String plan = br.readLine();
            planQueue.add(new Plan(Integer.parseInt(plan.split(" ")[0]), plan.split(" ")[1]));
        }

        int result = 0;
        int directionIndex = 0; // 동쪽부터 시작

        Deque<Point> snake = new ArrayDeque<>(); // 뱀 길이
        snake.add(new Point(1, 1));
        System.out.println(planQueue.size());
        // 여기까지 변수 초기화

        Plan plan = planQueue.poll();
        int seconds = plan.seconds;
        String direction = plan.direction;

        while (true) {
            Point snakeHead = new Point(snake.getFirst().x, snake.getFirst().y); // 얕은 복사와 깊은 복사!!!
            snakeHead.x += dx[directionIndex];
            snakeHead.y += dy[directionIndex];
            result++;
            System.out.println(snakeHead.x +", "+snakeHead.y);
            System.out.println(snake.size());

            if(snakeHead.x == 0 || snakeHead.x == N+1 || snakeHead.y == 0 || snakeHead.y == N+1) { // 뱀 머리가 벽에 부딫쳤을 경우
                break;
            }

            for(int j = 0; j < snake.size(); j++) {
                Point point = snake.pollFirst();
//                System.out.println(point.x+", "+point.y);
                if(snakeHead.x == point.x && snakeHead.y == point.y) {
                    break;
                }
                snake.addLast(point);
            }

            if(map[snakeHead.x][snakeHead.y] == 1) { // 사과를 찾은 경우
                appleCount--;
            }
            else {
                snake.pollLast();
            }
            snake.addFirst(new Point(snakeHead.x, snakeHead.y));

            if(result == seconds) {
                if(planQueue.size() > 0) {
                    Plan newPlan = planQueue.poll();
                    seconds = newPlan.seconds;
                    direction = newPlan.direction;

                    if(direction.equals("D")) {
                        if(directionIndex == 0) { // 동
                            directionIndex = 3;
                        }
                        else if(directionIndex == 1) { // 서
                            directionIndex = 2;
                        }
                        else if(directionIndex == 2) { // 북
                            directionIndex = 0;
                        }
                        else { // 남
                            directionIndex = 1;
                        }
                    }
                    else {
                        if(directionIndex == 0) { // 동
                            directionIndex = 2;
                        }
                        else if(directionIndex == 1) { // 서
                            directionIndex = 3;
                        }
                        else if(directionIndex == 2) { // 북
                            directionIndex = 1;
                        }
                        else { // 남
                            directionIndex = 0;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    static class Plan {
        int seconds;
        String direction;

        Plan(int seconds, String direction) {
            this.seconds = seconds;
            this.direction = direction;
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
*/