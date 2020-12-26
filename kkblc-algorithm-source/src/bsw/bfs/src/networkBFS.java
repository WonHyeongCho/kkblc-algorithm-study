/*
* bfs 네트워크
* */

import java.util.*;
public class networkBFS {

    public int solution(int n, int[][] computers) {

        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean [] visited = new boolean[n];

        for(int i = 0; i < n; i++) {

            //네트워크 망의 개수를 확인하므로 방문한 컴퓨터는 다시 방문하지 않아도 됨
            if(!visited[i]) {
                q.add(i);

                while(!q.isEmpty()){
                    int cur = q.poll();
                    visited[cur] = true;

                    for(int j = 0; j < n; j++) {
                        if(!visited[j] && computers[cur][j] == 1) q.add(j);
                    }
                }
                //너비우선 탐색으로 n번 컴퓨터가 연결된 모든 컴퓨터를 다 찾아내고 탐색을 종료하면서 망 개수 증가
                answer++;
            }
        }
        return answer;
    }
}
