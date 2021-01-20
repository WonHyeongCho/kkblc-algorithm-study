import java.util.Scanner;

public class Quiz1449 {
	/*
	 * 출처: https://www.acmicpc.net/problem/1449
	 * 
	 */
	static int N, L, tCnt;
	static int[] pipe = new int[1002];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		tCnt = 0; //테이프수
		
		for(int i=0; i<N; i++) {
			pipe[sc.nextInt()] = 1; //정상0, 물새면 1
		}
		
		for(int start=1; start<=1000; start++) {
			if(N<=0)
				break;
			
			if(pipe[start]==1) { //물 샐경우
				tCnt++; //테이프++
				for(int i=0; i<L; i++) {
					if(start+i>1000) //범위를 초과하면 break;
						break;
					if(pipe[start+i]==1) {
						N--; //물새는곳--
					}
					pipe[start+i] = 0;
				}
				start=start+L-1;
			}
		}
		
		System.out.println(tCnt);
	}

}
