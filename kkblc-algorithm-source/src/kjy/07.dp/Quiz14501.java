import java.util.Scanner;

public class Quiz14501 {
	/*
	 * 출처: https://www.acmicpc.net/problem/14501
	 * 
	 * 풀이:
	 * 퇴사화이팅!
	 * 상담소요일수, 금액이 담긴 배열을 뒤에서부터 탐색한다.
	 * i일까지 얻을수 있는 최대금액이 담긴배열 dp[]를 이용한다.
	 * 
	 * i날 일하면 i+1일에 돈을 받을수 있다.
	 * 
	 * i번째날을 선택했을경우 얻을수 있는 이익은?
	 * dp[i] = max(dp[i+1], dp[i]+dp[i+ t[i]])
	 *             그전까지최대이익(i일을 선택하지않을경우) vs i날수익 + (i+i작업일 더한날 일하면 얻는 수익) 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] timeArr = new int[N+2];
		int[] priceArr = new int[N+2];
		int[] dp = new int[N+2];
		
		for(int i=1; i<=N; i++) {
			timeArr[i] = sc.nextInt();
			priceArr[i] = sc.nextInt();
		}
		
		for(int i=N; i>= 1; i--) {
			//System.out.println("i = "+i);
			if(i+timeArr[i]>N+1) {
				priceArr[i] = priceArr[i+1]; //해당일자에 일을 못하면 이전까지의 최대값을 그대로 복사.
			}else{
				priceArr[i] = Math.max(priceArr[i+1], priceArr[i]+priceArr[i+timeArr[i]]); // i일얻는 최대수익 = MAX(i일 선택하지않는경우수익 vsi일 선택할경우 수익)
			}
			//System.out.println("priceArr["+i+"] = "+priceArr[i]);
		}
		
		System.out.println(priceArr[1]);
		
	}

}
