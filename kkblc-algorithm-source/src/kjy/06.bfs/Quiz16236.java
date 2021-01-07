package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 * Quiz16236 : https://www.acmicpc.net/problem/16236
 * 
 */
public class Quiz16236 {
	public static int[][] map;
	public static int[][] visited;
	public static int[] moveRow = {-1,0,1,0}; //위, 왼, 아, 오
	public static int[] moveCol = {0,-1,0,1};
	public static int N, sharkRow, sharkCol, sharkSize, fishCnt, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		fishCnt=0;
		sharkSize = 2;
		answer = 0;
		
		map = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int curNum = sc.nextInt();
				if(curNum==9) {
					sharkRow = i;
					sharkCol = j;
					map[i][j] = 0;
					continue;
				}
				map[i][j] = curNum;
			}
		}
		
		while(true) {
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited[i][j] = -1;
				}
			}
			
			FishInfo curFish = findFish(sharkRow, sharkCol);
			
			if(curFish.getRow()==N&&curFish.getCol()==N) { //초기화값 그대로
				break; //더이상 먹을 물고기가 없음
			}else {
				//해당위치로 이동하고
				sharkRow = curFish.getRow();
				sharkCol = curFish.getCol();
				//System.out.println("eat fish!! "+sharkCol+","+sharkRow+", +"+visited[sharkRow][sharkCol]);
				
				//물고기 먹고, 이동거리 더하고, 해당칸 지우기
				//   상어크기만큼 먹었으면 사이즈++, 먹은물고기초기화
				fishCnt++;
				answer+=visited[sharkRow][sharkCol];
				map[sharkRow][sharkCol] = 0;
				
				if(sharkSize==fishCnt) {
					sharkSize++;
					fishCnt = 0;
				}
			}
			
		}
		
		System.out.println(answer);
	}
	public static FishInfo findFish(int row, int col) {
		int fishRow = N, fishCol = N; //물고기 위치 row, col
		int minLen = N*N;     //최소길이
		Deque<FishInfo> que = new ArrayDeque<>();
		
		//System.out.println("find fish!! "+row+","+col);
		//방문
		visited[row][col] = 0;
		que.add(new FishInfo(row,col));
		
		while(!que.isEmpty()) {
			FishInfo cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int nextRow = cur.getRow()+moveRow[i];
				int nextCol = cur.getCol()+moveCol[i];
				
				// map범위를 벗어나거나, 이미 방문한경우
				if(nextRow<0||nextRow>N-1||nextCol<0||nextCol>N-1||visited[nextRow][nextCol]!=-1)
					continue;
				
				// 상어보다 물고기가 더 큰경우 이동불가
				if(sharkSize<map[nextRow][nextCol])
					continue;
				
				//방문처리
				visited[nextRow][nextCol] = visited[cur.getRow()][cur.getCol()]+1;
				que.add(new FishInfo(nextRow, nextCol)); //다음 방문위치
				
				//해당칸에 물고기가 있고, 먹을수있는경우
				if(map[nextRow][nextCol]>0&&sharkSize>map[nextRow][nextCol]) {
					
					//최단거리에 있는 물고기구하기
					if(visited[nextRow][nextCol]<minLen) {
						fishRow = nextRow;
						fishCol = nextCol;
						minLen = visited[nextRow][nextCol];
					}
					else if(visited[nextRow][nextCol]==minLen) {
						
						if(fishRow>nextRow) {//같은거리라면 맨 위에
							fishRow = nextRow;
							fishCol = nextCol;
						}else if(fishRow==nextRow&&fishCol>nextCol) {//row가 같다면 제일 왼쪽
							//fishRow = nextRow;
							fishCol = nextCol;
						}else {
							;
						}
					}
				}
			}
			
		}
		
		return new FishInfo(fishRow, fishCol);
	}
}
class FishInfo{
	int row;
	int col;
	public FishInfo() {
		;
	}
	public FishInfo(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
