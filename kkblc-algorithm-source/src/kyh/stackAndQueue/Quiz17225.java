package kyh.stackAndQueue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 링크: https://www.acmicpc.net/problem/17225
 * 제목: 세훈이의 선물가게
 */

/* 풀이
*  상민이, 지수를 서로 다른 큐에 넣고
*  큐에서 꺼내면서 끝나는 끝나는 시간과 구별값(상민 1, 지수 0)을 우선순위큐에 넣음
*  우선순위큐는 integer배열을 넣음
* */

/* 총평
 * 문제 자체는 어렵지 않음.
 * 다만 나는 소스코드가 긴편인거 같다.
 * 우선순위큐의 Comparator를 사용할줄 몰라 오래걸림.
 * */

// 파란색 상민이. B
// 빨강색 지수 R
public class Quiz17225 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp[] = br.readLine().split(" ");
        //BTime은 상민이가 포장하는데 걸리는 시간,
        //RTime은 지수가 포장하는데 걸리는 시간,
        //num은 손님 수.
        int BTime = Integer.parseInt(tmp[0]);
        int RTime = Integer.parseInt(tmp[1]);
        int num = Integer.parseInt(tmp[2]);

        Queue<int[]> bQ = new LinkedList<>(); //상민이
        Queue<int[]> rQ = new LinkedList<>(); //지수

        int tmpArr[] = new int[2];
        //B는 bQ에 R은 rQ에 삽입
        for(int i = 0 ; i<num; i++){
            tmp = br.readLine().split(" ");
            tmpArr = new int[2];
            tmpArr[0] = Integer.parseInt(tmp[0]); //0번째가 시작시간
            tmpArr[1] = Integer.parseInt(tmp[2]); //2번째가 갯수

            if(tmp[1].equals("B")){ //1번째가 B or R
                bQ.add(tmpArr);
            }else{
                rQ.add(tmpArr);
            }
        }

        // 0번 index에는 b(0) or q(1), 1번 인덱스에는 끝나는 시간.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });

        //curTime은 현재 시간
        //startTime은 포장을 시작하는ㅅ이간
        //packNum은 포장해야하는 갯수.
        int curTime = 0;
        int startTime = 0;
        int packNum = 0;
        int intArr[] = new int[2];


        while(!bQ.isEmpty()){
            intArr = bQ.poll();
            startTime = intArr[0];
            packNum = intArr[1];
            //현재시간보다 포장시작 시간이 같거나 크면 현재시간을 포장시간으로 대체.
            if(curTime <= startTime) curTime = startTime;
            //포장해야하는 갯수만큼 for loop
            for(int i = 0; i< packNum ; i++){
                curTime += BTime;
                //tmpArr은 큐에 들어가는 integer배열.
                tmpArr = new int[2];
                tmpArr[0] = 1; //우선순위큐에서 사용할 index. 상민이는 지수보다 우선순위가 낮음
                tmpArr[1] = curTime;
                pq.add(tmpArr);
            }
        }
        
        startTime = 0;
        curTime = 0;
        while(!rQ.isEmpty()){
            intArr = rQ.poll();
            startTime = intArr[0];
            packNum = intArr[1];
            if(curTime <= startTime) curTime = startTime;
            for(int i = 0; i< packNum ; i++){
                curTime += RTime;
                tmpArr = new int[2];
                tmpArr[0] = 0; //우선순위큐에서 사용할 index. 지수가 상민이보다 우선순위가 높음
                tmpArr[1] = curTime;
                pq.add(tmpArr);
            }
        }

        //bSum은 상민이가 포장한 갯수
        //rSum은 지수가 포장한 갯수
        int bSum = 0, rSum = 0; //
        StringBuilder bsb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();

        // 0번 index에는 b(0) or q(1), 1번 인덱스에는 끝나는 시간.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });

        //index는 선물이 몇번째인지를 나타냄.
        int index= 0;
        while(!pq.isEmpty()){
            intArr = pq.poll();
            index++;
            //상민이는 1
            if(intArr[0]==1){
                bSum++;
                bsb.append(index+" ");
            }else{ //지수는 0
                rSum++;
                rsb.append(index+" ");
            }
        }

        System.out.println(bSum);
        System.out.println(bsb);

        System.out.println(rSum);
        System.out.println(rsb);


    }

}
