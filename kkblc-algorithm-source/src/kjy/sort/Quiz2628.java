import java.util.Scanner;

/*
 * 2주차(정렬, 탐색)
 * 종이자르기: https://www.acmicpc.net/problem/2628
 * 세로 max, 가로max 각각 구해서 곱하면 최대넓이가 될듯
*/
public class Bj2628 {
	public static void main(String[] args) {
	     
		int col=0, row=0, maxCol = 0, maxRow = 0, cnt = 0;
		Scanner sc = new Scanner(System.in);
		col = sc.nextInt();
		row = sc.nextInt();
		
		int[] colArr = new int[col+1];
		int[] rowArr = new int[row+1];
		
		cnt = sc.nextInt();
		
		for(int i=0; i<cnt; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			if(num1==0) { //row
				 rowArr[num2] = 1;
			}else { //col
				colArr[num2] = 1;
			}
		}
		
		int curCnt=0;
		//maxRow를 구한다.
		for(int i=1; i<=row; i++) {
			curCnt++;
			
			if(rowArr[i]==1||i==row) { //잘렸거나, 끝까지가면 행 길이계산
				if(maxRow<curCnt) {
					maxRow = curCnt;
				}
				curCnt=0;
			}
		}
		
		curCnt=0;
		//maxCol를 구한다.
		for(int i=1; i<=col; i++) {
			curCnt++;
			
			if(colArr[i]==1||i==col) { //잘렸거나, 끝까지가면 열 길이계산
				if(maxCol<curCnt) {
					maxCol = curCnt;
				}
				curCnt=0;
			}	
		}
		
		System.out.println(maxCol*maxRow);
	}
}
