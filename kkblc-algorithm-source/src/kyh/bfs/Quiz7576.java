package kyh.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*6주차 BFS */
/*
 * 링크: https://www.acmicpc.net/problem/7576
 * 제목: 토마토
 */

/* 풀이

 * */

/* 총평
 * */

public class Quiz7576 {
    static int[][] arr;
    static int[][] dp;
    static int max = 0;

    static int sero;
    static int garo;
    static Queue<Node> q= new LinkedList<Node>();
    static Queue<Node> tomato= new LinkedList<Node>();

    static int dx[] = {0,0,1,-1}; //동서남북
    static int dy[] = {-1,1,0,0};
    static boolean flag;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = new String[2];
        temp = br.readLine().split(" ");
        sero = Integer.parseInt(temp[1]);
        garo = Integer.parseInt(temp[0]);
        arr = new int[sero][garo];
        dp = new int[sero][garo];


        for (int i = 0; i < sero ; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < garo; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);

                if(arr[i][j] == 1) {
                    tomato.add(new Node(i,j));
                    dp[i][j] = 1;
                }
            }
        }
        while(!tomato.isEmpty()){
            q.add(tomato.poll());
        }
        flag = false;
        bfs();


        if(flag){
            if( checkTomato() == -1){
                System.out.println(-1);
            }else{
                System.out.println(max-1);
            }
        }else{
            System.out.print(0);
        }
    }


    static void bfs(){

        while(!q.isEmpty()){
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = node.x + dx[i];
                int nY = node.y + dy[i];

                if(nX >=0 && nX<sero && nY >=0 && nY < garo
                        && arr[nX][nY] == 0 ){
                    flag = true;
                    arr[nX][nY] = 1;
                    dp[nX][nY] = dp[node.x][node.y]+1;
                    if(max < dp[nX][nY]) max = dp[nX][nY];
                    q.add(new Node(nX,nY));
                }

            }

        }

    }

    static void print(int arr[][]){
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int checkTomato(){
        for (int i = 0; i < sero; i++) {
            for (int j = 0; j < garo; j++) {

                if(arr[i][j] == 0 && dp[i][j] ==0){
                    return -1;
                }
//             if(arr[i][j] == -1 && dp[i][j] ==0){
//                 return 0;
//             }


            }
        }
        return 1;
    }

    public static class Node{
        public int x;
        public int y;

        Node(){}

        Node (int x, int y){
            this.x = x;
            this.y = y;
        }

    }

}
