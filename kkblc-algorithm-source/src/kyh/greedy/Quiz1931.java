package com.company.baek.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Quiz1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //회의 수
        int arr[][] = new int[N][3];


        String tmp[] = new String[2];

        //회의 시작시간, 끝시간 입력
        for (int i = 0; i < N; i++) {
            tmp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
        }

        //끝나는 시간 오름차순으로 정렬
        //끝나는 시간이 같을경우, 시작 시간 작은게 먼저오게
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int answer = 1;
        int end = arr[0][1];

        for (int i = 1; i < N; i++) {
            if(arr[i][0] >= end){
                answer++;
                end = arr[i][1];
            }
        }

        System.out.println(answer);

    }
    public static void print(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
