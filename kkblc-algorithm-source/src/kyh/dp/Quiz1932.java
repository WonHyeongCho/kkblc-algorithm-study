package kyh.07;

import java.util.Scanner;

public class Quiz1932 {
    public static void main(String[] args){
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();//Integer.parseInt(br.readLine());

        int arr[][] = new int[N][N]; //전체 배열
        int dp[][] = new int[N][N]; // dp 배열
        int max = 0;

        arr[0][0] = sc.nextInt();
        dp[0][0] = arr[0][0];
        String temp[] = new String[N];
        for(int i = 1 ; i<N; i++){
            for(int j = 0 ; j<i+1; j++){
                arr[i][j] = sc.nextInt();
                if(j==0) dp[i][j] = dp[i-1][j] + arr[i][j]; //맨앞칸
                else if(j==i) dp[i][j] = dp[i-1][j-1] + arr[i][j]; //맨뒷칸
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j], dp[i-1][j]+arr[i][j]);
                }
                if(max < dp[i][j]) max = dp[i][j];
            }
        }
        System.out.println(max);
    }
}
