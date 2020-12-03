package kyh.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*3주차*/

/*
 * 링크: https://www.acmicpc.net/problem/17225
 * 제목: 세훈이의 선물가게
 */

/* 풀이
*  우선순위 큐를 사용.
*  문제를 똑바로 읽어야함.
*  포장 끝나는 시간이 아니라 포장 시작하는 시간을 우선순위 큐에 넣어야함.
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


        int tmpArr[] = new int[2];
        //B는 bQ에 R은 rQ에 삽입

        //curTime은 현재 시간
        //startTime은 포장을 시작하는ㅅ이간
        //packNum은 포장해야하는 갯수.
        int bCurTime = 0;
        int rCurTime = 0;
        int startTime = 0;

        int packNum = 0;
        int intArr[] = new int[2];

        for(int i = 0 ; i<num; i++){
            tmp = br.readLine().split(" ");
            startTime = Integer.parseInt(tmp[0]); //0번째가 시작시간
            packNum = Integer.parseInt(tmp[2]); //2번째가 갯수

            if(tmp[1].equals("B")){ //1번째가 B or R
                if(startTime > bCurTime) bCurTime = startTime;

                for(int j = 0 ; j<packNum; j++){
                    tmpArr = new int[2];

                    tmpArr[0] = 0;
                    tmpArr[1] = bCurTime;
                    pq.add(tmpArr);
                    bCurTime += BTime;
                }
            }else{
                if(startTime > rCurTime) rCurTime = startTime ;

                for(int j = 0 ; j<packNum; j++){
                    tmpArr = new int[2];

                    tmpArr[0] = 1;
                    tmpArr[1] = rCurTime;

                    pq.add(tmpArr);
                    rCurTime += RTime;

                }
            }
        }

        //bSum은 상민이가 포장한 갯수
        //rSum은 지수가 포장한 갯수
        int bSum = 0, rSum = 0; //
        StringBuilder bsb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();

        //index는 선물이 몇번째인지를 나타냄.
        int index= 0;
        while(!pq.isEmpty()){
            intArr = pq.poll();
            index++;
//            System.out.println(intArr[0] + "/"+intArr[1]);
            //상민이는 0
            if(intArr[0]==0){
                bSum++;
                bsb.append(index+" ");
            }else{ //지수는 1
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
