import java.util.Scanner;

public class Quiz1149 {
	/*
	 * 출처: https://www.acmicpc.net/problem/1149
	 * 
	 * 풀이: N-1번째 집부터 각각 색을 칠했을때 N번째 집과의 최소비용합계를 업데이트 해준다.
	 *      이렇게 1번째 집까지 간다.
	 *      
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][]priceArr = new int[N+2][3]; // N개의 집 R, G, B
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				priceArr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=N-1; i>=1; i--) {
			for(int j=0; j<3; j++) {
				priceArr[i][j] = priceArr[i][j]+Math.min(priceArr[i+1][(j+1)%3], priceArr[i+1][(j+2)%3]);
			}
		}
		
		System.out.println(Math.min(priceArr[1][0],Math.min(priceArr[1][1],priceArr[1][2])));
		
	}

}
