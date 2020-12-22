package kyh.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*6주차 BFS */
/*
 * 링크: https://www.acmicpc.net/problem/16236
 * 제목: 아기 상어
 */

/* 풀이
 *  BFS문제
 * 시작점 부터 도착점까지의 거리의 최솟 값을 구하는 문제이기 때문에 BFS로 푼다.
 * 도착점이 여러개 일 수 있다.(상어~물고기 거리가 똑같은게 여러개 일 수 있기 때문이다)
 * 도착점이 여러개 일때 아래 두조건을 만족시켜야한다.
 * 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
 * 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 * 1. 우선 상어가 한마리의 물고기를 찾을 때마다 BFS를 돌린다. (크기가 20*20이어서 오래 걸리지 않는 것 같다)
 * 2. BFS 내에서 위 두조건을 만족시키는 위치를 찾는다.
 * 3. BFS를 빠져 나와서 해당 위치로 상어를 이동 시키며 이동한 거리를 찾는다.
 * */

/* 총평
 * 두 조건을 잘못 이해하여 문제 푸는데 오래 걸림. 북 -> 동 -> 서 -> 남 순서로 탐색 함.
 * 문제 자체가 어렵진 않음.
 * */


public class Quiz16236_2 {

    static int[][] arr;
    static int arrSize;
    static int[] dx = {-1,0,0,1}; //위 왼 오 아
    static int[] dy = {0,-1,1,0};

    static int distance[][];
    static int answer;
    static int eatFishNum;
    static int curX, curY; //현재 위치 겸 물고기 먹은 위치.

    static Queue<int[]> q = new LinkedList<int[]>();
    static int currentSharkSize;

    static int minX, minY; //
    static int minDist; //시작점을 기준으로 물고기 먹은 자리 까지의 거리

    static boolean change; //bfs안에서 바뀌었는지 안 바뀌었는지를 체크

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arrSize = Integer.parseInt(br.readLine());
        String tempArr[] = new String[arrSize];

        //전체 배열
        arr =new int[arrSize][arrSize];
        //시작점부터 도착지점까지의 거리를 저장하는 2차원 배열
        distance = new int[arrSize][arrSize];

        //현 위치 초기화
        curX=0;
        curY=0;

        for(int i = 0 ; i< arrSize ;i++){
            tempArr = br.readLine().split(" ");
            for(int j=0; j<arrSize ;j++){
                arr[i][j] = Integer.parseInt(tempArr[j]);

                if(arr[i][j]==9){
                    //상어 위치
                    curX=i;
                    curY=j;
                    //상어가 있던 위치는 9 -> 0 으로 수정
                    arr[i][j] = 0;
                }
            }
        }

        currentSharkSize = 2; //초기 상어의 크기는 2
        eatFishNum = 0; //지금까지 먹은 물고기 숫자.
        answer = 0;//output값.

        change = true;

        //change변수가 true가 되었다는것은 bfs동안 바뀌었다는 것을 의미.
        //change변수가 false로 남아 있다는 것은 bfs안에서 바뀌지 않았다는 것을 의미 -> 더이상 먹을게 없다.
        while(change){
            change = false;
            minX = 1000;
            minY = 1000;
            minDist = 1000;

            bfs(curX,curY); //bfs한번 끝나는거는 먹을 물고기 하나 찾은거임.

            if(change){
                eatFishNum++;
                if(eatFishNum == currentSharkSize){
                    eatFishNum = 0;
                    currentSharkSize++;
                }

                //먹은거 0으로 바뀜
                curX = minX;
                curY = minY;
                arr[curX][curY] = 0;

                //방문한곳 클리어
                initDistance();
                answer += minDist; //
            }else{
                break;
            }

        }

        System.out.println(answer);
    }


    public static void bfs(int x, int y){
        int tempArr [] = new int[2];
        tempArr[0] = x;
        tempArr[1] = y;

        q.add(tempArr);

        while(!q.isEmpty()){
            int tempArr2[] = q.poll();
            int tempX = tempArr2[0];
            int tempY = tempArr2[1];


            for(int i = 0; i<4 ;i++){

                int tx = tempX+dx[i];
                int ty = tempY+dy[i];

                //이동할수 있는지 체크
                if( tx >=0 && tx <arrSize && ty >=0 && ty <arrSize //배열 크기 벗어나면 안됨.
                        && arr[tx][ty]<=currentSharkSize //나와 크기가 같거나 작으면 이동 가능
                        && distance[tx][ty] ==0 // 방문하지 않은곳 방문

                ){
                    // distance배열을 활용하여 시작 점 부터 현재 지점까지의 거리를 확인 가능
                    distance[tx][ty] = distance[tempX][tempY]+1;
                    // System.out.println("이동 : "+(tx+1) + "/"+(ty+1));

                    //먹음
                    //해당 자리에 물고기가 있는지를 체크
                    if(0 < arr[tx][ty] && arr[tx][ty] < currentSharkSize
                            && distance[tx][ty] <= minDist ){
                        //x값이 작을수록 위,
                        //y값이 작을수록 왼
                        if(minX > tx){
                            minX = tx;
                            minY = ty;
                            minDist = distance[tx][ty];
                            change = true;
                        }else if(minX == tx){
                            if(minY > ty){
                                minY = ty;
                            }
                        }
                    }

                    int tempArr3[] = new int[2];
                    tempArr3[0] = tx;
                    tempArr3[1] = ty;

                    q.add(tempArr3);
                }
            }//forloop 끝
        }

    }
    static void initDistance(){
        distance = new int[arrSize][arrSize];
    }
}