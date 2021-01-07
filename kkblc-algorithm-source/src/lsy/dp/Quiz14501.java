package lsy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz14501 {
	public static int[] time;
	public static int[] pay;
	public static int[] mem;
	public static int N;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N  = Integer.parseInt(br.readLine());
			
			StringTokenizer st;
			time = new int[N+1];
			pay = new int[N+1];
			mem = new int[N+1];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				time[i+1] = Integer.parseInt(st.nextToken());
				pay[i+1] = Integer.parseInt(st.nextToken());
				mem[i] = -1;
			}
			mem[N] = -1;
			
			int max = 0;
			for(int i = 1; i<=N ; i++) {
				int temp = check(i);	
				max = temp> max? temp: max;
			}
			System.out.println(max);
			
		}catch(IOException e) {
			
		}
	}
	
	public static int check(int day) {
		if(mem[day]!=-1 ) return mem[day];
		int nextDay = day + time[day];
		if(nextDay>N+1) {
			mem[day] = 0;
			return 0;
		}
		int temp;
		int nowMoney=0;
		for(int i=nextDay; i<=N; i++) {
			temp = check(i);	
			nowMoney = temp> nowMoney? temp: nowMoney;
		}
		mem[day] = nowMoney + pay[day];
		return mem[day];
	}

}
