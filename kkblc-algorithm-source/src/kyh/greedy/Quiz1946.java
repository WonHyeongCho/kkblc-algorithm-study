package com.company.baek.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Quiz1946 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); //testCase
        int applicantNum = 0; // 지원자수

        StringBuilder sb = new StringBuilder();
        
        
        while(testCase>0){
            testCase--;
            applicantNum = Integer.parseInt(br.readLine());
            int [][] applicantArr = new int [applicantNum][2]; //배열
            String tmp[] = new String[2];
            //배열에 점수 삽입
            for (int i = 0; i < applicantNum; i++) {
                tmp = br.readLine().split(" ");
                applicantArr[i][0] = Integer.parseInt(tmp[0]);
                applicantArr[i][1] = Integer.parseInt(tmp[1]);
            }

            //배열 첫번째값 오름차순 정렬
            Arrays.sort(applicantArr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0]==o2[0]){
                        return o1[1] - o2[1];
                    }else{
                        return o1[0] - o2[0];
                    }
                }
            });

            int tmpScore = applicantArr[0][1];
            int answer = 1; //정렬한 이후 첫번째 지원자는 무조건 뽑힌다.
            for (int i = 1; i < applicantArr.length; i++) {
                if(applicantArr[i][1] < tmpScore){
                    tmpScore = applicantArr[i][1];
                    answer++;
                }
            }
            sb.append(answer+"\n");

        }
        System.out.print(sb);

    }
}
