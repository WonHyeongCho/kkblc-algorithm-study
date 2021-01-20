/*
* 퀴즈 1946 그리디 문제
*
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz1946 {

    static int score[];
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bfr.readLine());
        for(int i=0;i<number;i++){
            int applyNewbe = Integer.parseInt(bfr.readLine());
            score = new int[applyNewbe+1];
            for(int j=0;j<applyNewbe;j++){
                StringTokenizer token = new StringTokenizer(bfr.readLine());
                int flag = Integer.parseInt(token.nextToken()); //서류 등수
                score[flag]= Integer.parseInt(token.nextToken()); //면접 등수
            }

            int cnt=1;
            int standard=score[1]; //서류의 합격자 면접 등수
            for(int k=2;k<applyNewbe;k++){
                if(standard > score[i]){ //서류 합격자 등수보다 면접 등수가 작다면 (제쳤다)
                    cnt++; //올려라 합격으로
                    standard= score[i]; //순위는 중복이 안된다.
                }
            }

            System.out.println(cnt);


        }

    }
}
