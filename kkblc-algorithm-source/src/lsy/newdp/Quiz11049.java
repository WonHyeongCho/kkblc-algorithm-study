package lsy.newdp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz11049 {
	public static Matrix[] matrixs;
	public static int[][] mem;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mem = new int[N][N];
		matrixs = new Matrix[N];
		StringTokenizer st;
		for(int i=0; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Matrix temp = new Matrix(r,c);
			matrixs[i] = temp;
		}
		
		int ans = findMin(0, N-1);
		System.out.println(ans);
	}
	
	public static int findMin(int start, int end) {
		if(mem[start][end] !=0 || start ==end) {
			return mem[start][end];
		}
		
		int answer= 999999999 ;
		
		for(int i=0; i<end-start;i++) {
			int temp = findMin(start,start+i)+ findMin(start+i+1, end);
			temp+= (matrixs[start].r * matrixs[start+i].c * matrixs[end].c);
			answer= temp< answer? temp: answer;
		}
		//answer += matrixs[start].r * matrixs[start].c * matrixs[end].c;
		mem[start][end] = answer;
		
		return mem[start][end];                                                                 
	}
	
	
	static class Matrix{
		int r;
		int c;
		Matrix(int r, int c){
			this.r = r; 
			this.c = c;
		}
	}
	
}
