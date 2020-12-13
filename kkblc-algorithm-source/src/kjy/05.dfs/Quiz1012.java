import java.util.Scanner;

public class Quiz1012 {
	static boolean [][] map; //이미 방문했는지 또는 배추가 있는지 표시하기 위한 배열
	static int[] moveRow = {-1,0,1,0}; //위, 오, 아, 왼
	static int[] moveCol = {0,1,0,-1}; //위, 오, 아, 왼
	static int T, M, N, K, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		//테스트케이스 T만큼 반복수행 필요
		for(int t=0; t<T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			map = new boolean[N][M];
			
			//배추 위치 입력
			for(int i=0; i<K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				map[r][c] = true; //배추위치에 1로 표시(방문후 0으로 set)
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0;j<M; j++) {
					if(map[i][j]) { //배추 있으면 
						cnt++;      //지렁이++
						move(i, j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	public static void move(int row, int col) {
			map[row][col] = false; //방문 후 false 처리
			
			for(int i=0; i<4; i++) {
				int nextRow = row+moveRow[i];
				int nextCol = col+moveCol[i];
				//배추가 있다면, 상하좌우 방문
				if(nextRow>=0&&nextRow<N&&nextCol>=0&&nextCol<M&&map[nextRow][nextCol]) {
					move(nextRow,nextCol);
				}
			}
	}
}
