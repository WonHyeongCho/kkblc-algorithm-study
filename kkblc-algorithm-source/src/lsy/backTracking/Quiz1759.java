package lsy.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Quiz1759 {
	public static int L;
	public static int C;
	public static String[] words;
	public static StringBuilder answer= new StringBuilder();
	public static HashSet<String> mos = new HashSet<String>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		words = new String[C];
		for(int i=0; i< C; i++) {
			words[i] = st.nextToken();
		}
		Arrays.sort(words);
		
		mos.add("a");
		mos.add("e");
		mos.add("i");
		mos.add("o");
		mos.add("u");
		
		
		for(int i=0; i<C;i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(words[i]);
			if(mos.contains(words[i])) {
				check(i,1,0, sb);
			}else {
				check(i,0,1, sb);
			}
		}
		System.out.println(answer);
	}
	
	public static void check(int start, int mo, int ja, StringBuilder sb) {
		if(sb.length() == L) {
			if(mo>=1 && ja>=2) {
				answer.append(sb.toString());
				answer.append("\n");
			}
			return;
		}
		for(int i=start+1; i<C; i++) {
			sb.append(words[i]);
			if(mos.contains(words[i])) {
				check(i, mo+1, ja,sb);
			}else {
				check(i, mo, ja+1, sb);
			}
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
