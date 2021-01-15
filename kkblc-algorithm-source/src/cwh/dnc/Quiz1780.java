package cwh.dnc;

/*
 * 제목: 종이의개수
 * 링크: https://www.acmicpc.net/problem/1780
 */

import java.util.Scanner;

public class Quiz1780 {
    static int N, zero, minusOne, one;
    static int[][] map = new int[2187][2187]; // 3의 7승

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        divide(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static boolean check(int row, int col, int n) { // 분할된 지도가 모두 0, 1, -1 인지 확인
        int std = map[row][col];

        for(int i = row; i < row + n; i++) {
            for(int j = col; j < col + n; j++) {
                if (map[i][j] != std) {
//                    System.out.println("(" + row + ", " + col + ", " + n + ", false)");
                    return false;
                }
            }
        }
//        System.out.println("(" + row + ", " + col + ", " + n + ", true)");
        return true;
    }

    static void divide(int row, int col, int n) {
        if(check(row, col, n)) { // 찾았다!
            if(map[row][col] == 0) {
                zero++;
            } else if (map[row][col] == 1) {
                one++;
            } else if (map[row][col] == -1) {
                minusOne++;
            }
        } else {
            int next = n / 3;

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    divide(row + i * next, col + j * next, next);
                }
            }
        }
    }
}
