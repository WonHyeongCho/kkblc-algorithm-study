package com.company.baek.문자열;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz10942 {

    public static int[][] dpArr;
    private static String[] strArr;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int N = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dpArr = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int questionNum = 0;
        questionNum = Integer.parseInt(br.readLine());

        int flag =1;

        strArr = new String[N];
        int start=0, end = 0, tempN=0;
        while(st.hasMoreTokens()){
            strArr[tempN] = st.nextToken();
            tempN++;
        }

        String tempArr[] = new String[2];

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<questionNum ; i++){
            tempArr = br.readLine().split(" ");
            start = Integer.parseInt(tempArr[0]) -1;
            end = Integer.parseInt(tempArr[1]) -1;

            flag = dpFunc(start, end);

            if(flag==1) sb.append("1\n");
            else sb.append("0 \n");

        }
        //sysout을 여러번 하는것은 좋지않다.
        System.out.println(sb);

    }

    public static int dpFunc(int start, int end){
        int answer = 1;
        if(start < end){
            if(dpArr[start][end]==0){
                if(!strArr[start].equals(strArr[end])){
                    dpArr[start][end]=-1;
                    return dpArr[start][end];
                }else{
                    dpArr[start][end]=1;
                    answer = dpFunc(start+1 ,end-1);
                    if(answer == -1)      dpArr[start][end]=-1;
                }
            }else{
                return dpArr[start][end];
            }
        }
        return answer;
    }
}