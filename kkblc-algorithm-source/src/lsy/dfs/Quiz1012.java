package lsy.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz1012 {
	public static int[] dx= {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	public static int M;
	public static int N;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tcNum = Integer.parseInt(br.readLine());
			int answer=0;
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<tcNum;i++) {
				answer = 0;
				StringTokenizer st = new StringTokenizer(br.readLine());	
				M = Integer.parseInt(st.nextToken());
				N = Integer.parseInt(st.nextToken());
				int[][] field = new int[M][N];
				visited = new boolean[M][N];
				
				int cabbageNum = Integer.parseInt(st.nextToken());
				for(int j=0;j<cabbageNum;j++) {
					st = new StringTokenizer(br.readLine());
					field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
				}
				
				for(int j=0;j<M;j++) {
					for(int k=0; k<N;k++) {
						if(!visited[j][k] && field[j][k]==1) {
							dfs(field, j,k);
							answer++;
						}
					}
				}
				sb.append(answer);
				sb.append("\n");
			}
			System.out.println(sb);

			
		}catch(IOException e) {
			
		}
	}
	public static void dfs(int[][] field, int j, int k) {
		visited[j][k] = true;
		for(int i=0;i<dx.length;i++) {
			if(j+dx[i]>=0 && j+dx[i] <M && k+dy[i]>=0 && k+dy[i]<N) {
				if(field[j+dx[i]][k+dy[i]] ==1&& !visited[j+dx[i]][k+dy[i]]) {
					//System.out.println(j + " : " + k);
					dfs(field, j+dx[i], k+dy[i]);	
				}
			}
		}
		
	}
}
