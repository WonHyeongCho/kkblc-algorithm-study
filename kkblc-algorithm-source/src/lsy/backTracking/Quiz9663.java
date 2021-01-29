package lsy.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Quiz9663 {
	public static boolean[] notX;
	public static boolean[] notY;
	public static boolean[] notSum;
	public static boolean[] notDif;
	public static int N;
	public static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		notX = new boolean[N];
		notY = new boolean[N];
		notSum = new boolean[N+N];
		notDif = new boolean[N+N];
		
		int total = N*N;
		notX[0] = true; 
		for(int j=0; j<N;j++) {
			int now = j;
			if(total- now >=N){
				notY[j] = true;
				notSum[j] = true;
				notDif[-j+N] = true;
				check(0,j, 1);	
				notY[j] =false;
				notSum[j] = false;
				notDif[-j+N] = false;
			}
		}
		if(N==1) answer = 1;
		System.out.println(answer);
	}
	
	public static void check(int x ,int y, int temp) {
		if(N==1) return;
		if(temp == N ) {
			answer++;
		}
		for(int i=x+1;i<N;i++) {
			if(temp<i) {
				return;
			}
			for(int j=0;j<N;j++) {
				if(!notX[i] && !notY[j]
						&& !notSum[i+j] && !notDif[i-j+N]) {
					notX[i] = true;
					notY[j] = true;
					notSum[i+j]= true;
					notDif[i-j+N]=true;
					check(i,j,temp+1);
					notX[i] = false;
					notY[j] = false;
					notSum[i+j]= false;
					notDif[i-j+N]=false;
				}
			}
		}
	}
}
