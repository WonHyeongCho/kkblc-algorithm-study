package lsy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz1946 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tcNum = Integer.parseInt(br.readLine());
			for(int i=0; i<tcNum;i++) {
				int N = Integer.parseInt(br.readLine());
				int[] arr = new int[N+1];
				StringTokenizer st; 
				for(int j=0; j< N;j++) {
					st = new StringTokenizer(br.readLine());
					arr[Integer.parseInt(st.nextToken())]= Integer.parseInt(st.nextToken());
				}
				
				int result = findNum(arr);
				System.out.println(result);
			}
			
			
		}catch(IOException e) {
			
		}
	}
	public static int findNum(int[] arr) {
		int answer= 0 ;
		int lastNum = 1;
		for(int i=1; i<arr.length;i++) {
			if(i==1) {
				answer++;
				lastNum = arr[1];
			}else {
				if(arr[i] < lastNum) {
					lastNum = arr[i];
					answer++;
				}
			}
		}
		return answer;
	}

}
