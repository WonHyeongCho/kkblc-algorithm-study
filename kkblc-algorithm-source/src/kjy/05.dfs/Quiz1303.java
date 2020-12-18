import java.util.Scanner;

public class Quiz1303 {
	/*
	  백준1303(전쟁-전투): https://www.acmicpc.net/problem/1303
	*/
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	static int[] moveRow = {-1,0,1,0};
	static int[] moveCol = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new char[M][N];
		visited = new boolean[M][N];
		
		int wCnt = 0, bCnt = 0;
		
		for(int i=0; i<M; i++) {
			String str = sc.next();
			for(int j=0; j<str.length(); j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='B') { //W부터 카운트할꺼니까 B는 우선 visited = true처리
					visited[i][j] = true;
				}
			}
		}
		
		int curCnt = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]&&map[i][j]=='W') { //'W'를 먼저 카운트
					curCnt = count('W',i,j);
					wCnt += (curCnt*curCnt); //count값의 제곱만큼 위력을 더해주면된다.
				}
			}
		}
		
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='W') { //B 카운트할꺼니까 W는 우선 visited = true처리
					visited[i][j] = true;
				}else {
					visited[i][j] = false;
				}
			}
		}
		
		curCnt = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]&&map[i][j]=='B') { //'W'를 먼저 카운트
					curCnt = count('B',i,j);
					bCnt += (curCnt*curCnt);
				}
			}
		}
		
		System.out.println(wCnt+" "+bCnt);
	}
	static int count(char c, int row, int col) { //문자 c를 세서 병사의 위력을 계산하는 함수 
		visited[row][col] = true;
		int cnt=1; //내거 count
		
		for(int i=0; i<4; i++) {
			int nextRow = row + moveRow[i];
			int nextCol = col + moveCol[i];
			
			//범위내에 있고&&아직방문안했으며&&문자c가 존재하는경우 
			if(nextRow>=0&&nextRow<M&&nextCol>=0&&nextCol<N&&!visited[nextRow][nextCol]&&map[nextRow][nextCol]==c) {
				cnt+=count(c,nextRow,nextCol);
			}
		}
		
		return cnt;
	}
}
