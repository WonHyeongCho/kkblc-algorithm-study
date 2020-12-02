package kyh.sortAndSearch;


/*
 * 링크: https://www.acmicpc.net/problem/2606
 * 제목: 바이러스
 */


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
