import java.util.Scanner;

public class Quiz1946 {
	/*
	 * 출처: https://www.acmicpc.net/problem/1946
	 * 풀어: 서류순위순서로 정렬한후에, for문돌리면서 나보다 index낮은애들의 면접순위와 비교
	 *      -> 이러면 시간초과
	 *      현재까지의 최솟값(높은순위)을 기억해둬야함.
	 *      그다음에 나오는애는 면접순위가 이전에 나왔던 순위들보다 높아야 채용
	 */
	static int[] score;
	static int T, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			N = sc.nextInt();
			score = new int[N+1];
			
			int textScore, examScore, min = N+1, cnt = 0;
			
			for(int i=0; i<N; i++) {
				textScore = sc.nextInt();
				examScore = sc.nextInt();
				score[textScore] = examScore;
			}
			
			/*
			for(int i=1; i<=N; i++) {
				boolean flag = true;
				for(int j=i; j>0; j--) {
					if(score[i]>score[j]) {
						flag = false;
						break;
					}
				}
				if(flag) {
					cnt++;
				}
			}
			*/
			for(int i=1; i<=N; i++) {
				//서류순위로 정렬되어있는상태
				//현재까지의 최솟값(높은순위)을 기억해둬야함.
				//그다음에 나오는애는 면접순위가 이전에 나왔던 순위들보다 높아야 채용
				if(score[i]<min){
					min = score[i];
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}

}
