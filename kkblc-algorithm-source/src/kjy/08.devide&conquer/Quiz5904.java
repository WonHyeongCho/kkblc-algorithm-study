import java.util.Scanner;

public class Quiz5904 {
	/*
	 * 출처: https://www.acmicpc.net/problem/5904
	 * 풀이: 무무무
	 * 
	 */
	static String curMoo = "moo";
	static int N, mooLength;
	
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
			//System.out.println("cur = "+moo);
		}
	}
}
