import java.util.Scanner;

public class Quiz2630 {
	/*
	 * 출처 : https://www.acmicpc.net/problem/2630
	 * 풀이방법 : 현재 영역이 다 같은색인지 검사
	 *         1.같은색이면 count하고 끝
	 *         2.다른색이라면 n/2크기로 4등분한다(단 n>1일때만)
	 *         계속 반복
	 */
	public static int[][] map;
	public static int N, wCnt=0, bCnt=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		solve(N, 1, 1);
		
		System.out.println(wCnt);
		System.out.println(bCnt);
	}
	/*
	 * row,col부터 size만큼의 크기 영역이 다 같은색인지 검사해서 
	 * 그 결과(t/f)를 return해준다.
	 * 
	 */
	public static boolean check(int size,int curRow, int curCol) {
		boolean flag = true;
		
		for(int i=curRow; i<curRow+size; i++) {
			for(int j=curCol; j<curCol+size; j++) {
				if(map[i][j]!=map[curRow][curCol]) {
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}
	public static void solve(int curSize, int curRow, int curCol) {
		if(check(curSize,curRow, curCol)) { //해당 영역이 다 같은색이라면
			if(map[curRow][curCol]==0) {
				wCnt++; //하얀색일경우 wCnt++
			}else {
				bCnt++; //파란색일경우 bCnt++
			}
			return;
		}else {
			solve(curSize/2, curRow, curCol);
			solve(curSize/2, curRow, curCol+(curSize/2));
			solve(curSize/2, curRow+(curSize/2), curCol);
			solve(curSize/2, curRow+(curSize/2), curCol+(curSize/2));
		}
	}
}
