import java.util.Scanner;

public class Quiz2447 {
	/*
	 * 출처: https://www.acmicpc.net/problem/2447
	 * N * N 의 공간에 대해서 N/3 * N/3 크기의 공강 9개로 나누어 찍어준다.
	 * IF(N==3) PRINT
	 */
	public static int N;
	public static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = ' ';
			}
		}
		
		solve(N, 0, 0);
		
		//String res = "";
		//처음에는 String에 다 담아서 접합해서 한번에 출력하려 했는데 timeout나서 변경하였음
		for(int i=0; i<N; i++) {
			/*
			for(int j=0; j<N; j++) {
				res+=map[i][j];
			}
			res+='\n';
			*/
			System.out.println(map[i]);
		}
		//System.out.println(res);
	}
	public static void solve(int size, int row, int col) {
		if(size==1) { // 재귀 호출이 끝나는 부분
			map[row][col] = '*';
			return;
		}
		
		//입력받은 n 값을 계속 3씩 나눠준다.
		size/=3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i!=1||j!=1) 
					solve(size, row+i*size, col+j*size);
			}
		}
		
	}
}
