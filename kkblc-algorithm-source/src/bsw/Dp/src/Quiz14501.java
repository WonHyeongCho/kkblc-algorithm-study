/*
* 퇴사 문제 DP문제
* 메모이제이션 문제
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Quiz14501 { //바텀업 방식으로 풀이됨.
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //일하는 날을 계산
        int N = Integer.parseInt(reader.readLine());
        //시간과 돈을 N만큼 만든다.
        int [] times = new int[N+2];
        int [] pays = new int[N+2];
        for(int i=1;i<=N;i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine()," ");
            times[i] = Integer.parseInt(tokenizer.nextToken());
            pays[i] = Integer.parseInt(tokenizer.nextToken());
        }

        // DP(i)에 대해 상담을 받았을 때 최대값을 보자
        // DP테이블에 저장을한다.
        // dp(1) 1일차에는 0이다. 3개의 시간이 소요가 되니까
        // dp(2) 2일차에도 0이다
        // dp(3) 3일차에는 10이다.  T(1) 3 , 10 /  T(3) 1, 10
        // dp(4) 4일차에는 30이다.
        // dp(5) 5일차에는 30이다.
        // dp(6) 6일차에는 45이다.
        // dp(7) 7일차에는 45이다.
        int max = 0; //최대한 번 돈을 뜻한다.
        int [] dp = new int[N+6];

        for(int i=1;i<=N+1;i++){
            //처음과 2일차는 0으로 나온다.
            dp[i] = Math.max(dp[i],max);

            //이전에 저장된 최대 수익 vs 이번 일차로 변경되면서 생긴 최대 수익
            dp[times[i]+i] = Math.max(dp[times[i]+i],pays[i]+dp[i]);

            //max 출력될 최대 수익
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }

}
