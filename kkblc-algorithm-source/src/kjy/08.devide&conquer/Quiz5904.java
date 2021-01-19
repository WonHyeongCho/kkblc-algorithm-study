import java.util.Scanner;

public class Quiz5904 {
	/*
	 * 출처: https://www.acmicpc.net/problem/5904
	 * 풀이: 무무무
	 * 
	 * 1
	 * 1 4 8
	 * 1 4 8
	 * 
	 * 
	 */
	static String moo = "moo", curMoo = "moo";
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println(moo());
	}
	static char moo() {
		while(true) {
			if(N<=moo.length()) {
				return moo.charAt(N-1);
			}
			curMoo = curMoo+"o";
			moo = moo+curMoo+moo;
			//System.out.println("cur = "+moo);
		}
	}
}
