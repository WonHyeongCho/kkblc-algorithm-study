package cwh.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/*
 * 링크: https://www.acmicpc.net/problem/1715
 * 제목: 카드 정렬하기
 */

public class Quiz1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long result = 0;

        PriorityQueue<Long> pQueue = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            long number = Long.parseLong(br.readLine());
            pQueue.offer(number);
        }

        if(n == 1) {
            System.out.println("0");
            return;
        }

        while(pQueue.size() > 1) {
            long a1 = pQueue.poll();
            long a2 = pQueue.poll();
            long sum = a1 + a2;

            pQueue.offer(sum);

            result += a1 + a2;
        }

        System.out.println(result);
    }
}