package lsy.newdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz11066 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcNum = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<tcNum; i++) {
			int fileNum = Integer.parseInt(br.readLine());
			int[] files = new int[fileNum];
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<fileNum;j++) {
				files[j]= Integer.parseInt(st.nextToken());
				
			}
			int[][] dp = new int[fileNum][fileNum];
			int[][] sum = new int[fileNum][fileNum];
			int ans = fileMerge(files, dp, 0, fileNum-1, sum);
			System.out.println(ans);
		}
	}
	public static int fileMerge(int[] files, int[][] dp, int start, int end,int[][] sum) {
		if(dp[start][end] !=0) {
			return dp[start][end];
		}
		//System.out.println(start + " : " + end);
		if(start==end) {
			dp[start][end]=0;
			return 0;
		}
		int answer =1092394012;
		for(int i=0; i<end-start;i++) {
			int temp= fileMerge(files, dp, start, start+i, sum) + fileMerge(files, dp, start+i+1, end,sum);
			answer = temp < answer? temp : answer;
		}
		answer += fileSum(files, sum, start,end);
		dp[start][end] = answer;
		//System.out.println("---------- "+answer);
		return dp[start][end];
	}
	public static int fileSum(int[] files, int[][] sum, int start, int end) {
		if(sum[start][end] !=0) {
			return sum[start][end];
		}
		int answer=0;
		for(int i=start; i<=end;i++) {
			answer += files[i];
		}
		sum[start][end] = answer;
		return sum[start][end];
	}
}
