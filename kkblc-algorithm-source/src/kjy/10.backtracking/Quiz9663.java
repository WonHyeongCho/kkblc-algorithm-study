import java.util.Scanner;

public class Quiz9663 {
	/*
	 * 출처: https://www.acmicpc.net/problem/9663
	 * 구현방안:
	 * NxN개의 판에 N개의 퀸을 서로 공격하지 않도록 배치해야함
	 * N개의 퀸을 순서대로 배치할때 중간에 불가능한 케이스는 끝까지 탐색하지 않도록함.
	 * 
	 * 재귀를 통해서 N개의 퀸을 배치함.
	 * MAP에 N번째 퀸을 배치하면서 같은 row, col, 대각선에 숫자를 표시해서 다음 퀸배치할때에는 해당칸은 선택하지 않도록함.
	 */
	static int[][] map;
	static int N, cnt=0;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			//배열 초기화
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=N; k++) {
					map[j][k] = 0;
				}
			}
			//재귀호출로 row, col윛치에 퀸을 놓고, 표시해준다.
			//그리고 그 다음row호출
			setQueen(1,i);
		}
		System.out.println(cnt);
	}
	public static void setQueen(int row, int col) {
		if(row>=N) { //끝까지 왔다면 카운트
			cnt++;
			return;
		}
		//row, col에 퀸을 놨다면 같은 row,col,대각선에 표시해줘야함
		//1.같은row 표시
		for(int i=1; i<=N; i++) {
			if(map[row][i]==0) { //아직 미방문
				map[row][i] = row;
			}
		}
		//2.같은col 표시
		for(int i=1; i<=N; i++) {
			if(map[i][col]==0) { //아직 미방문
				map[i][col] = row;
			}
		}
		//3.대각선 표시
		//왼쪽 위로
		for(int i=row-1,j=col-1; i>=1&&j>=1; i--,j--) {
			if(map[i][j]==0) {
				map[i][j] = row;
			}
		}
		//오른쪽 아래로
		for(int i=row+1,j=col+1; i<=N&&j<=N; i++,j++) {
			if(map[i][j]==0) {
				map[i][j] = row;
			}
		}
		//오른쪽 위로
		for(int i=row-1,j=col+1; i>=1&&j<=N; i--,j++) {
			if(map[i][j]==0) {
				map[i][j] = row;
			}
		}
		//왼쪽 아래로
		for(int i=row+1,j=col-1; i<=N&&j>=0; i++,j--) {
			if(map[i][j]==0) {
				map[i][j] = row;
			}
		}
		
		for(int i=1; i<=N; i++) {
			//아직 미방문일때만 재귀
			if(map[row+1][i]==0){
				setQueen(row+1,i);
				//row+1번째 퀸과 겹치는부분 지워주고 다음위치선택
				for(int j=1; j<=N; j++) {
					for(int k=1; k<=N; k++) {
						if(map[j][k]==row+1) 
							map[j][k] = 0;
					}
				}
			}
		}
		
	}
}
