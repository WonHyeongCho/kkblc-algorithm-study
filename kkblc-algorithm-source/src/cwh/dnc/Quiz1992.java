package cwh.dnc;

/*
 * 제목: 쿼드트리
 * 링크: https://www.acmicpc.net/problem/1992
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz1992 {
    static int N, m;
    static int[][] map = new int[64+1][64+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String data = br.readLine();

            for(int j = 0; j < data.length(); j++) {
                map[i][j] = data.charAt(j)-48;
            }
        }

        divide(0, 0, N);
    }

    static boolean check(int row, int col, int n) {
        int num = map[row][col];
        for(int i = row; i < row+n; i++) {
            for(int j = col; j < col+n; j++) {
                if(map[i][j] != num) {
                    return false;
                }
            }
        }
        m = num;
        return true;
    }

    static void divide(int row, int col, int n) {
        if(check(row, col, n)) {
            System.out.print(m);
        } else {
            System.out.print("(");
            int middle = n/2;
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    divide(row+middle*i, col+middle*j, middle);
                }
            }
            System.out.print(")");
        }
    }
}
