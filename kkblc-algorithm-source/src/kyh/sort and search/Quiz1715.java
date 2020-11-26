package com.company.baek.정렬탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Quiz1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //우선순위큐 사용.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int N = 0;
        N = Integer.parseInt(br.readLine());

        long answer = 0;
        //N개 만큼의 숫자 우선순위큐에 삽입
        for(int i = 0 ; i<N; i++){
            //입력받는 숫자를 우선순위큐에 바로 삽입
            pq.add(Integer.parseInt(br.readLine()));
        }
        //N번째, N+1번째 숫자의 합을 저장하는 변수
        int tmpSum = 0;
        //우선순위큐 사이즈를 1보다 크게 함
        //pq.isEmpty()함수를 사용하면 안됨. 맨마지막거를 포함하면 안되기 때문
        while(pq.size()>1){
            tmpSum = pq.poll() + pq.poll();
            answer += tmpSum;
            pq.add(tmpSum);
        }
        System.out.println(answer);
    }
}
