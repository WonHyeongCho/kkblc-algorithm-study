package com.company.baek.정렬탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0, M = 0;
        String tempNM[] = br.readLine().split(" ");
        N = Integer.parseInt(tempNM[0]);
        M = Integer.parseInt(tempNM[1]);

        String strNArr[] = new String[N]; //듣도 못한놈

        //듣도 못한 놈을 배열에 넣기.
        for (int i = 0; i<N;i++){
            strNArr[i] = br.readLine();
        }
        //듣도 못한 놈 sorting.
        Arrays.sort(strNArr);

        //strM에는 보도 못한놈이 한명씩 들어감.
        String strM = "";
        //보도 못한 놈의 sum
        int MSum = 0;

        ArrayList<String> answer = new ArrayList<>();
        for(int j = 0; j<M ; j++){
            strM = br.readLine();
            //보도 못한 놈이 들어 왔을때 바이너리 서치를 통해 듣도 못한 놈에게 속해 있는지 확인.q
            //0 이상이면 속해 있음. 음수이면 없음
            if(Arrays.binarySearch(strNArr,strM)>=0){
                answer.add(strM);
                MSum++;
            }
        }
        //듣도보도못한놈을 sorting
        Collections.sort(answer);

        //듣도보도못한놈을 sorting
//        answer.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });

        System.out.println(MSum);

        for(int i = 0 ; i< MSum; i++){
            System.out.println(answer.get(i));
        }

    }
}
