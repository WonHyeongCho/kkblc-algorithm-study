import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

/*
* 아기 상어
* 자신과 같은 사이즈를 먹을 떄 사이즈가 커진다.
* 상하좌우로 이동한다.
* 가장 왼쪽에 있는 물고기를 먹는다.
* https://kim6394.tistory.com/199를 보고 다시 하였다.
*
* */
public class Quiz16236 {

    static class Fish{ // 상어 물고기 class
        int y;
        int x;

        Fish(int y, int x){
            this.x = x;
            this.y = y;
        }
    }

    static class Dir{ // 상어부터 물고기 간의 거리 class
        int y;
        int x;
        int val;

        Dir(int y,int x, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    static int N;
    static int [][] map;
    static int [][] copy;

    static Fish shark;
    static ArrayList<Fish> fish;

    static boolean[][] visit;
    static int[] dy={-1,1,0,0};
    static int[] dx={0,0,-1,1};

    static int result;
    static int sharkSize;

    public static void bfs(int x, int y){

        int babySharkX = x;
        int babySharkY = y;

        sharkSize =2;
        int count =0;

        while (true){
            copy = new int[N][N]; // 00으로 초기화
            visit = new boolean[N][N]; //모두다 false

            check(babySharkX,babySharkY,copy);

            int minDir = Integer.MAX_VALUE;

            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    //0보다 크고 상어크기보다 작으며 거리가 0보다 큰곳 copy[i][j] > 0
                    if(map[i][j] < sharkSize && map[i][j] >0 && copy[i][j] > 0)
                        if(minDir > copy[i][j])
                            minDir = copy[i][y];
                }
            }

            ArrayList<Fish> list = new ArrayList<>(); //먹을 수 있는 물고기

            for (int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    //0보다 크고 상어크기보다 작으며 거리가 최소와 같은 것을 고른다.
                    if(map[i][j] < sharkSize && map[i][j] >0 )
                        list.add(new Fish(i,j));
                }
            }
            if(list.size()==0){
                //더이상 먹을 물고기가 없다.
                break;
            }else if(list.size()==1){
                //먹을 물고기가 1마리면
                int fishY = list.get(0).y;
                int fishX = list.get(0).x;

                result +=copy[fishY][fishX];//이동거리 구하기
                map[fishY][fishX] =0;//먹은 자리값 0으로 만들기
                count++;

                if(count ==sharkSize){
                    //먹은 물고기 수가 상어 크기만큼 되었을때 크기가 커진다.
                    sharkSize++;
                    count = 0; //크기가 증가되면 다시 카운트 0으로 초기화 한다.
                }

                map[babySharkY][babySharkX] =0;
                babySharkY = fishX; //상어의 위치값을 변경
                babySharkX = fishX;

                continue;
            }else {
                //두개 이상의 물고기가 존재하는 경우
                int minY = Integer.MAX_VALUE;

                //먹을 수 있는 물고기 중 가장 작은 y인덱스를(위에서 찾는 경우다) 찾는다.
                for(int i=0;i<list.size();i++){
                    if(minY >list.get(i).y){// 제일 처음의 값이 큰것이 필요하므로 max로 설정한다.
                        minY = list.get(i).y; //제일 작은 것이 가장가까운 위쪽에 있는 것이다.
                    }
                }

                int minX = Integer.MAX_VALUE;
                int minCnt =0;

                //먹을 수 있는 물고기 중 왼쪽에 있는 x인덱스 찾기
                for(int i=0;i<list.size();i++){
                    if(list.get(i).y==minY){ // 위에 있는 값이랑 같으면 왼쪽을 살핀다.
                        minCnt++;
                        if(list.get(i).x<minX)   //제일 큰 값에서 작은 값을 비교한다.
                            minX = list.get(i).x; //제일 왼쪽의 값을 저장한다. (작은값)
                    }
                }

                if(minCnt ==1){
                  //가장 위에 있는 물고기가 하나일 경우
                    int fishX=0;
                    int fishY=0;
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).y==minY){
                            fishX=list.get(i).y; //물고기를 잡아먹기 위해 좌표를 따라간다.
                            fishY=list.get(i).x;
                            break;
                        }
                    }
                    result +=copy[fishY][fishX];//이동거리 구하기
                    map[fishY][fishX] =0;//먹은 자리값 0으로 만들기
                    count++;

                    if(count == sharkSize){
                        sharkSize++;
                        count=0;
                    }
                    map[babySharkX][babySharkY] =0;
                    babySharkX = fishX;
                    babySharkY = fishY;
                    continue;
                }else {
                    //둘 이상이면 가장 최소의 x인덱스 물고기를 먹어야 한다.
                    //물고기가 2개 이상일때 가장 최소의 x를 알아야한다.
                    int fishX=0;
                    int fishY=0;
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).y==minY && list.get(i).x==minX){
                            fishX=list.get(i).y;
                            fishY=list.get(i).x;
                            break;
                        }
                    }
                    result +=copy[fishY][fishX];//이동거리 구하기
                    map[fishY][fishX] =0;//먹은 자리값 0으로 만들기
                    count++;

                    if(count == sharkSize){
                        sharkSize++;
                        count=0;
                    }
                    map[babySharkX][babySharkY] =0;
                    babySharkX = fishX;
                    babySharkY = fishY;
                    continue;
                }


            }

        }
    }
    public static void check(int y, int x, int [][] copy){

        int count = 0;
        Queue<Dir> queue = new LinkedList<>(); //연결 리스트 사용

        queue.add(new Dir(y,x,count)); // 해당 큐에 x, y ,사이즈를 넣음
        copy[y][x] = count;  //이동한 거리는 0이다.[해당 좌표를 탐색하는 것이]
        visit[y][x] = true;  //1. 처음들어왔을때 == 아기상어의 위치 [true] 2. 처음이 아닐때 경로를 이동하는것을 확인.

        while (!queue.isEmpty()){
            Dir d = queue.poll(); // 끄낸다.

            for(int i =0;i< 4;i++){
                int ny = d.y + dy[i];
                int nx = d.x + dx[i];
                int nval = d.val;

                if(ny<0||nx<0||ny>=N||nx>=N) continue; //테두리에서 나가면 다시

                if(!visit[ny][nx] && map[ny][nx] <=sharkSize){ //방문하지 않았고 아기상어의 값보다 작거나 같은 것을 찾는다.
                    queue.add(new Dir(ny,nx,nval+1)); //전체가지 수를 가져온다.
                    copy[ny][nx] = nval+1; //이동한 거리를 계속 더한다.
                    visit[ny][nx] =true;//방문을 한것으로 넘긴다.

                }
            } //for문을 돌았을때 큐가 쌓였으면 그에 해당하는 값을 계속 풀어준다.

        }

    }


    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        fish = new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer tokenizer= new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
                if(map[i][j]==9){
                 shark = new Fish(i,j);
                }
                if(map[i][j]!=0 && map[i][j]!=9){
                    fish.add(new Fish(i,j));
                }
            }
        }
        //물고기를 상어랑 물고기로 둘로 나누어 한것이다.
        bfs(shark.y, shark.x);
        System.out.println(result);

    }


}
