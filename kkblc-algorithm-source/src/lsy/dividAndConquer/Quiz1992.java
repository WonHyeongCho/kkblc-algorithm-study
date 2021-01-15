package lsy.dividAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1992
public class Quiz1992 {

	public static String[][] map;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			map = new String[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				String line = br.readLine();
				String[] temp = line.split("");
				for(int j=1; j<=N;j++) {
					map[i][j] = temp[j-1];
				}
			}
			String answer =check(N, N,N);
            
			System.out.println(answer);
			
		}catch(IOException e) {}
		
	}
	
	public static String check(int size, int x, int y) {
		if(size ==1) {
			return map[x][y];
		}
		String a = check(size/2, x-size/2, y-size/2);
		String b = check(size/2, x-size/2, y);
		String c = check(size/2, x, y-size/2);
		String d = check(size/2, x, y);
		String answer;
		if(a.equals(b) && b.equals(c) && c.equals(d)
				&&(a.equals("1") || a.equals("0"))) {
			answer = a;	
		}else {
			StringBuilder sb = new StringBuilder();
			sb.append("(");
			sb.append(a);
			sb.append(b);
			sb.append(c);
			sb.append(d);
			sb.append(")");
			answer = sb.toString();
		}
		return answer;
	}

}
