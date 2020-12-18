import java.util.Scanner;

public class Quiz1937 {
	/*
	 * 백준1937:https://www.acmicpc.net/problem/1937
	 * 처음에 단순 dfs로 풀어보려했으나, timeout남.
	 * 따라서 dp를 통해서 풀도록 변경필요
	 */
	static int[][] map;
	static int[][] visited;
	static int[] moveRow = {-1,0,1,0};
	static int[] moveCol = {0,1,0,-1};
	static int N = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited  = new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				answer = Math.max(dfs(i,j),answer);	//깊이우선탐색시작. 현재까지 answer값과 dfs탐색결과값중 큰값으로 업데이트
			}
		}
		System.out.println(answer);
	}
	public static int dfs(int row, int col) {
		if(visited[row][col]>0) {
			return visited[row][col];
		}
		
		//시작일은 1일로 초기화해줌
		int day = 1;
		
		for(int i=0; i<4; i++) {
			int nextRow = row + moveRow[i];
			int nextCol = col + moveCol[i];
			
			//범위내에 있고, 다음으로 이동가능한경우
			if(nextRow>=0&&nextRow<N&&nextCol>=0&&nextCol<N&&map[row][col]<map[nextRow][nextCol]) {
				day = Math.max(dfs(nextRow, nextCol)+1, day);
				visited[row][col] = day;
			}
		}
		return day;
	}
}
