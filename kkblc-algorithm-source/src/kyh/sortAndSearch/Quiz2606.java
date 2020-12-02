package kyh.sortAndSearch;

/*3주차*/

/*
 * 링크: https://www.acmicpc.net/problem/2606
 * 제목: 바이러스
 */

/* 풀이
 *  bfs, dfs로 풀수 있다. 나는 dfs로 품
 *  어차피 1~N까지의 노드 중 1과 연결된 부분만 찾으면 된다.
 *  방문했는지, 연결되어있는지 확인하면된다.
 * */

/* 총평
 * 오랜만의 dfs라 조금 당황했따.
 * 간단한 dfs라 다행이었다.
 * dfs는 들어가는 조건, 탈출조건을 잘 작성해야한다.
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz2606 {
    static int visited[];
    static int arr[][];
    static int computerNum;
    static int answer = 0;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerNum = Integer.parseInt(br.readLine());

        arr = new int[computerNum][computerNum];
        visited = new int[computerNum];

        int n = Integer.parseInt(br.readLine());

        String strArr[] = new String[2];
        int x = 0;
        int y = 0;
        for(int i = 0; i<n; i ++){
           strArr =  br.readLine().split(" ")       ;
           x = Integer.parseInt(strArr[0])-1;
           y = Integer.parseInt(strArr[1])-1;
           arr[x][y] = 1;
           arr[y][x] = 1;
        }

        //dfs start
        dfs(0,0);
        //정답에서 -1을 하는 이유는 문제에서 출발점인 1을 제외 하였기 때문.
        System.out.print(answer-1);
    }


    static void dfs(int start, int end){

        for(int j = 0 ; j<computerNum; j++){
            //해당 row 방문 안했고, 해당 좌표가 1이면
            if(visited[j]==0 && arr[start][j] == 1){
                //해당 row 방문으로 변경
                visited[j] = 1;
                answer++;
                dfs(j,0);
            }
        }
        return ;
    }

}
