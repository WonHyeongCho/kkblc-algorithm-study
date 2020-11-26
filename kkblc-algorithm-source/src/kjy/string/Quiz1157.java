import java.util.Scanner;

/*
 * 1주차 복습문제
 * 단어공부: https://www.acmicpc.net/problem/1157
 * 대소문자 구분없이 카운트!
 * 
 */
public class Bj1157 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] resArr = new int[91];
		int maxNum = 0;
		int maxCnt = 0;
		char maxCh = '?';
		
		for(int i=0; i<str.length(); i++) {
			int inCh = (int)str.charAt(i);
			
			if(inCh>=97&&inCh<=122) {
				inCh-=32;
			}
			
			resArr[inCh]++;
			
			if(resArr[inCh]>maxNum) {
				maxNum = resArr[inCh];
				maxCh = (char)inCh;
			}
		}
		
		for(int i=65; i<=90; i++) {
			if(maxNum==resArr[i]) {
				maxCnt++;
			}
		}
		
		if(maxCnt>1) {
			maxCh = '?';
		}
		
		System.out.println(maxCh);
	}

}
