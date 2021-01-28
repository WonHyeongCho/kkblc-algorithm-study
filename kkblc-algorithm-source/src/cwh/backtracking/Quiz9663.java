package cwh.backtracking;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/*
 * 제목: N-Queen
 * 링크: https://www.acmicpc.net/problem/9663
 * 해설: 매우 어렵다... 백트래킹의 boundary 는 같은 행, 열, 대각선에 있는 경우 back
 * 행, 열을 1차원 배열로 표현한다. colArray 의 i는 열, colArray[i] 는 행
 */

public class Quiz9663 {
    static int N, count;
    static int[] colArray = new int[15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        solve(0);

        System.out.println(count);
    }

    static void solve(int col) {
        if(col == N)
            count++;
        else {
            for(int i = 0; i < N; i++) {
                colArray[col] = i;

                if(promising(col)){
                    solve(col + 1);
                }
            }
        }
    }

    static boolean promising(int col) {
        for(int i = 0; i < col; i++) {
            if(colArray[col] == colArray[i] || Math.abs(colArray[col] - colArray[i]) == (col-i)) { // 같은 열이거나 || 대각선일 경우
                return false;
            }
        }

        return true;
    }
}
