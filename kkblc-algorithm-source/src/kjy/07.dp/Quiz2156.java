import java.util.Scanner;

public class Quiz2156 {
	/*
	 * 출처: https://www.acmicpc.net/problem/2156
	 * 
	 * 풀이: 포도주를 3잔연속으로 먹을수 없다.
	 *      그럼 i번째 포도주의 차례에서 max값을 어떻게 구할것인가.
	 *      1. i번째 포도주 선택 + dp[i-2]  
	 *      2. i번째 포도주 선택 + i-1번째 포도주 선택 + dp[i-3]
	 *      3. dp[i-1] i번째 포도주 선택 안함.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] juice = new int [N+3];
		int[] dp = new int [N+3];
		
		for(int i=3; i<=N+2; i++) {
			juice[i] = sc.nextInt();
		}
		
		for(int i=3; i<=N+2; i++) {
			dp[i] = Math.max(juice[i] + dp[i-2], juice[i]+juice[i-1]+dp[i-3]); // i-2번째 까지합 + i번째잔 선택 VS i-3번째까지합 + i-1번째, i번째 잔 선택
			dp[i] = Math.max(dp[i],dp[i-1]); //위에 Max값 vs i번째를 선택하지 않는 경우
		}
		
		//for(int i=3; i<=N+2; i++)
		//	System.out.print(dp[i]+" ");
		
		System.out.println(dp[N+2]);
	}

}
