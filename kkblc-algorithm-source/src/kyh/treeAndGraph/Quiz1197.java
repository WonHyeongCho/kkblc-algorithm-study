package com.company.baek.트리그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*4주차*/

/*
 * 링크: https://www.acmicpc.net/problem/1197
 * 제목: 최소 스패닝 트리
 */

/* 풀이
 *  나는 크루스칼로 품
 * */

/* 총평
 *
 * */


public class Quiz1197 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strArr[] = new String[2];
        strArr = br.readLine().split(" ");
        //정점의 갯수
        int V = Integer.parseInt(strArr[0]);
        //간선의 갯수
        int E = Integer.parseInt(strArr[1]);


        int arr[] = new int[V];

        //우선순위 큐 재정의.
        //배열의 2번째 index로 비교하기
        //오름차순.
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        //배열에 값 넣어놓기.
//        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i<V ; i++){
//            map.put(i+1,i+1);
            arr[i] = i;
        }

        //입력 받는 임시 string 배열
        String strArr2[] = new String[3];
        // x는 시작 노드, y는 끝노드 번호
        // w는 x와 y 사이의 가중치
        int x = 0, y = 0, w = 0;
        for(int i = 0 ; i<E ; i++){

            strArr2 = br.readLine().split(" ");
            x = Integer.parseInt(strArr2[0]);
            y = Integer.parseInt(strArr2[1]);
            w = Integer.parseInt(strArr2[2]);

            int tmpArr[] = new int[3];
            
            //아래에서 -1을 하고 넣는 이유는
            //arr이 0번부터 들어가기 때문
            //입력은 1부터 시작하기 때문에 -1을 해줌
            tmpArr[0] = Math.min(x,y) -1 ;
            tmpArr[1] = Math.max(x,y) -1;
            tmpArr[2] = w;
            pq.add(tmpArr);
        }

        int answer = 0;
        //노드를 이은 간선의 갯수
        int NCnt = 0;
        //임시 integer 배열
        int intArr[]= new int[3];

        //start는 시작노드, end는 끝 노드
        int start = 0, end = 0;

        while(!pq.isEmpty()){
            intArr = pq.poll();

//            start = map.get(intArr[0]);
//            end = map.get(intArr[1]);
            //start에는 첫번째 노드의 마지막 노드 번호?
            //end에는 두번째 노드의 마지막 노드 번호?
            start = arr[intArr[0]];
            end = arr[intArr[1]];

            //두개의 끝지점이 다른경우 -> 두개의 노드를 잇는다.
            if(start != end) {
                //첫 번째 노드의 마지막 노드 번호를 두번째 노드의 마지막 노드 번호로 바꾼다.
                arr[intArr[0]] = end;
//                map.put(intArr[0],end);
//                for( int key : map.keySet() ){
//                    if(map.get(key)==start){
//                        map.put(key,end);
//                    }
//                }
                //첫 번째 노드와 연결된 마지막 노드 번호와 같은 다른 노드들의 마지막 노드 번호를 바꾼다.
                for (int i = 0; i < V; i++) {
//                    if(map.get(i+1)==start){
//                        map.put(i+1,end);
//                    }
                    if (arr[i] == start) {
                        arr[i] = end;
                    }
                }
                //이어진 간선 수를 1 더한다.
                NCnt++;
                //정답에 간선수를 더한다.
                answer += intArr[2];
            }
            //지금까지 이은 간선의 갯수가 노드수-1일 경우 끝.
            if(NCnt==V-1) break;
        }
        System.out.println(answer);
    }

}
