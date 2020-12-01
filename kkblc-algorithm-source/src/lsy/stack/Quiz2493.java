package lsy.stack;
/*
 * 백준 :https://www.acmicpc.net/problem/2493
 * */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;



public class Quiz2493 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayDeque<int[]> stack = new ArrayDeque<int[]>(); //for 두번 돌면 시간초과 됨 --> stack 에 필요한 부분만 담기
			StringBuilder sb = new StringBuilder();
			int now;
			int idx=1;
			String zero = "0 ";
			String blank = " ";
			int[] temp;
			while(st.hasMoreTokens()) {
				now = Integer.parseInt(st.nextToken());
				while(!stack.isEmpty()) { 
					temp = stack.peek();
					if(temp[1]<now) {
						stack.pop(); //stack 안에는 현재값 보다 큰 아이가 남아있음
					}else {
						sb.append(temp[0]+blank); //현재값 보다 더 큰 탑 있으면 스톱
						break;
					}
				}
				if(stack.isEmpty()) {
					sb.append(zero);
				}
				stack.push(new int[] {idx,now});
				idx++;
			}
			System.out.println(sb);
		}catch(IOException e) {
		}
	}
}
