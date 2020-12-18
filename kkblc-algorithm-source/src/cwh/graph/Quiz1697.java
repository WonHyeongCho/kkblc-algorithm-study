package cwh.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Quiz1697 {
    static int N; // 수빈이 위치
    static int K; // 동생 위치
    static Queue<Integer> bfsQueue;
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        bfsQueue = new LinkedList<>();
        memo = new int[100001];

        bfsQueue.add(N);
        bfs();

        System.out.println(memo[K]);
    }

    static void bfs() {
        while(true) {
            if(!bfsQueue.isEmpty()){
                int curLocation = bfsQueue.poll(); // 현재 위치

                if(curLocation == K) { // 동생과 수빈이 위치가 같을 경우
                    return;
                }

                if(curLocation+1 <= 100000 && memo[curLocation+1] == 0) {
                    bfsQueue.add(curLocation+1);
                    memo[curLocation+1] = memo[curLocation]+1;
                }

                if(curLocation-1 >= 0 && memo[curLocation-1] == 0) {
                    bfsQueue.add(curLocation-1);
                    memo[curLocation-1] = memo[curLocation]+1;
                }

                if(curLocation*2 <= 100000 && memo[curLocation*2] == 0) {
                    bfsQueue.add(curLocation*2);
                    memo[curLocation*2] = memo[curLocation]+1;
                }
            }
        }
    }
}
