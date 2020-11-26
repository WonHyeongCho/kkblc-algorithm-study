package lsy.sort;
/*
 * https://www.acmicpc.net/problem/10942
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quiz10942 {
	public static String[] numbers;
	public static int[][] mem;
	public static final int OK=100;
	public static final int NOT=200;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int totalNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			numbers = new String[totalNum+1];
			mem = new int[totalNum+1][totalNum+1];
			
			int i=1;
			while(st.hasMoreTokens()) {
				numbers[i] = st.nextToken();
				i++;
			}
			int tcNum = Integer.parseInt(br.readLine());
			String[] str;
			int start;
			int end;
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<tcNum;j++) {
				str = br.readLine().split(" ");
				start= Integer.parseInt(str[0]);
				end = Integer.parseInt(str[1]);
				int result = check(start,end);
				if(result==OK) {
					sb.append("1"); 
				}else {
					sb.append("0");
				}
				if(j != tcNum-1) sb.append("\n"); 
			}
			System.out.println(sb);
		}catch(IOException e) {
			
		}
	}
	public static int check(int start,int end) {
		if(mem[start][end]!=0) {
			return mem[start][end];
		}
		if(!numbers[start].equals(numbers[end])) {
			mem[start][end]=NOT;
		}else {
			if(start+1<end-1) {
				mem[start][end] = check(start+1,end-1);
			}else {
				mem[start][end]=OK;
			}
		}
		//System.out.println("start:end " + start + ": "+end+" : "+mem[start][end]+"..?");
		return mem[start][end];
	}
}