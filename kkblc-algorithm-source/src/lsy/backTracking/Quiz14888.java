package lsy.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz14888 {
	public static int min= 1000000000;
	public static int max= -1000000000;
	public static int[] numbers;
	public static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		int i=0;
		while(st.hasMoreTokens()) {
			numbers[i++] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		i=0;
		
		int plus= Integer.parseInt(st.nextToken());
		int minus =  Integer.parseInt(st.nextToken());
		int multi = Integer.parseInt(st.nextToken());
		int divide =  Integer.parseInt(st.nextToken());
		
		check(0, numbers[0],  plus, minus, multi, divide);
		System.out.println(max);
		System.out.println(min);
	}
	public static void check(int idx, int number, int plus, int minus, int multi, int divide) {
		
		//System.out.println(plus +" , " + minus +" , " + multi+" , "+divide);
		//더하기
		if(plus !=0) {
			check(idx+1, number + numbers[idx+1], plus-1, minus, multi, divide);
		}
		//뺴기
		if(minus !=0) {
			check(idx+1, number - numbers[idx+1], plus, minus-1, multi, divide);
		}
		// 곱하기
		if(multi !=0) {
			check(idx+1, number * numbers[idx+1], plus, minus, multi-1, divide);
		}
		//나누기
		if(divide!=0) {
			check(idx+1, number / numbers[idx+1], plus, minus, multi, divide-1);
		}
		if(idx == N-1) {
			min = Math.min(min, number);
			max = Math.max(max, number);
		}
	}
}
