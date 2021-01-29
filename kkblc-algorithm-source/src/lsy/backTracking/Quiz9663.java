package lsy.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Quiz9663 {
	//public static HashSet<Integer> notX;
	//public static HashSet<Integer> notY;
	public static boolean[] notX;
	public static boolean[] notY;
	//public static HashSet<Integer> notSum;
	public static boolean[] notSum;
	public static boolean[] notDif;
	//public static HashSet<Integer> notDif;
	public static int N;
	public static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//notX = new HashSet<Integer>();
		//notY = new  HashSet<Integer>();
		notX = new boolean[N];
		notY = new boolean[N];
		notSum = new boolean[N+N];
		notDif = new boolean[N+N];
		//notSum = new HashSet<Integer>();
		//notDif = new HashSet<Integer>();
		
		int total = N*N;
		notX[0] = true; 
		for(int j=0; j<N;j++) {
			int now = j;
			if(total- now >=N){
				//notX.add(0);
				//notY.add(j);
				notY[j] = true;
				//notSum.add(j);
				//notDif.add(-j);
				notSum[j] = true;
				notDif[-j+N] = true;
				check(0,j, 1);	
				//notY.remove(j);
				notY[j] =false;
				notSum[j] = false;
				notDif[-j+N] = false;
				//notSum.remove(0+j);
				//notDif.remove(-j);
			}
		}
		if(N==1) answer = 1;
		System.out.println(answer);
	}
	
	public static void check(int x ,int y, int temp) {
		if(N==1) return;
		//System.out.println(x + " : " + y + " : " + temp );
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
					//notSum.remove(i+j);
					//notDif.remove(i-j);	
				}
			}
		}
	}
}
