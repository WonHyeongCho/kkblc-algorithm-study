import java.util.Scanner;

public class Quiz1992 {
	/*
	 * 출처: https://www.acmicpc.net/problem/1992 
	 * 풀아: 네등분으로 나눠서 비교하는 로직이 필요함.
	 *      인터넷 풀이 참조
	 *      두가지가 필요함
	 *      1. 나누는 로직 devide
	 *      
	 *      2. 해당구성요소가 모두 같은지 체크
	 *      
	 */
	static int N;
	static int[][] map; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		devide(0,0,N);
		
	}
	
	public static boolean isSame(int row, int col, int size) {
		int curDot = map[row][col];
		/* 기준이 되는 row,col에 있는 값과
		 * size만큼 구역의 값이 모두 동일한지 판단
		 */
		
		for(int i=row; i<row+size;i++) {
			for(int j=col; j<col+size; j++) {
				if(curDot!=map[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static void devide(int row, int col, int size) {
		if(isSame(row, col, size)) { /* 해당범위에 점들이 모두 동일할경우 하나의 값만 출력 */
            System.out.print(map[row][col]);
        }else { /* 그렇지 않다면 4개의 구역으로 나눠서 탐색&출력 */
            System.out.print("(");
            int newSize = size/2;
            
            devide(row, col, newSize);            //왼쪽 위
            devide(row, col + newSize, newSize);  //오른쪽 위
            devide(row + newSize, col, newSize);  //왼쪽 아래
            devide(row + newSize, col + newSize, newSize); //오른쪽 아래
            
            System.out.print(")");
        }
	}
}
