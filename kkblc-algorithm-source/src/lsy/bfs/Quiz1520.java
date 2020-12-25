package lsy.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1520
public class Quiz1520 {
	public static int M, N;
	public static int[] dx = new int[] {0,0,1,-1};
	public static int[] dy = new int[] {1,-1,0,0};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[M][N];
			int[][] mem = new int[M][N];
			
			for(int i=0; i<M ; i++) {
				st =  new StringTokenizer(br.readLine());
				int j=0;
				while(st.hasMoreTokens()) {
					mem[i][j]=-1;
					map[i][j++] = Integer.parseInt(st.nextToken());
				}
			}
			mem[M-1][N-1]= 1;

			int ans = dfs(map, mem, 0,0);
			System.out.println(ans);
			
		}catch(IOException e) {
			
		}
	}
	public static int dfs(int[][] map,int[][] mem, int i, int j) {

		if(mem[i][j]!=-1) {
			return mem[i][j];
		}

		int nextX, nextY;
		int ans = 0;
		
		for(int k=0; k< dx.length;k++) {
			nextX = dx[k] + i;
			nextY = dy[k] + j;
			if(nextX >=0 && nextX <M && nextY >=0 && nextY <N) {
				if(map[i][j] > map[nextX][nextY]) {
					ans += dfs(map, mem,nextX,nextY);
				}
			}
		}
		mem[i][j] = ans;
		return mem[i][j];
	}

}
