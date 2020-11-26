package com.company.baek.정렬탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Quiz1026 {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //우선 한줄을 String 배열로 받아옴.
        String strArr[]  = br.readLine().split(" ");
        Integer aArr[] = new Integer[N];
        //Arrays.sort에서 reverse를 쓰려면 Integer로 선언해야함
        Integer bArr[] = new Integer[N];

        //받아온 String 배열을 integer 배열에 넣음.
        for(int i = 0; i<N;i++){
            aArr[i] = Integer.parseInt(strArr[i]);
        }
        strArr  = br.readLine().split(" ");
        //받아온 String 배열을 integer 배열에 넣음.
        for(int i = 0; i<N;i++){
            bArr[i] = Integer.parseInt(strArr[i]);
        }

        //A배열 오름차순 정렬
        Arrays.sort(aArr);
        //B배열 내림차순 정렬.
        Arrays.sort(bArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return Integer.compare(o2, o1);
            }
        });
        //내림 차순 방법 2. Arrays.sort(bArr, Collections.reverseOrder());


        int answer = 0;
        for(int i = 0; i<N;i++){
            answer += aArr[i]*bArr[i];
        }

        System.out.println(answer);
    }
}
