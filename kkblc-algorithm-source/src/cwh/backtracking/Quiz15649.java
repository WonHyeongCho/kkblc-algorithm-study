package cwh.backtracking;

/*
 * 제목: N과 M (1)
 * 링크: https://www.acmicpc.net/problem/15649
 * 해설: 체크하는 배열과 값을 넣는 배열을 만들고 1부터 계속 solve 돌림
 * 체크하는 배열이 true면 백트래킹!
 */


import java.util.Scanner;

public class Quiz15649 {
    static int N, M;
    static boolean[] checkArray = new boolean[8+1];
    static int[] answerArray = new int[8+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for(int i = 1; i <= N; i++) solve(1, i);

    }

    static void solve(int index, int n) {
//        System.out.println(index + ", " + n);

        if(check(n)) { // 넣어도 된다.
            checkArray[n] = true;
            answerArray[index] = n;
            if (index == M) { // 다 넣었을 경우
                for (int i = 1; i <= M; i++) {
                    System.out.print(answerArray[i] + " ");
                }
                System.out.println();
            } else {
                for (int i = 1; i <= N; i++) {
                    solve(index + 1, i);
                }
            }
            checkArray[n] = false;
        }
    }

    static boolean check(int index) {
        // 값을 넣었는지 검사
        return !checkArray[index];
    }
}
