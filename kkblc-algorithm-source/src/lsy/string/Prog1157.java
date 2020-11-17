package lsy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prog1157 {
//https://www.acmicpc.net/problem/1157
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String word = br.readLine();
			char answer=  solution(word);
			System.out.println(answer);
		}catch(IOException e) {
			
		}
	}
	
	public static char solution(String word) {
		char answer='?';
		word = word.toUpperCase();
		int[] alpabet = new int[26];
		int size = word.length();
		int now;
		for(int i=0; i<size; i++) {
			now = (int)word.charAt(i) -65;
			alpabet[now]++;
		}
		
		int max = 0;
		int index = 0;
		boolean flag= false;
		for(int j=0;j<alpabet.length;j++) {
			if(alpabet[j]>max) {
				max = alpabet[j];
				index = j;
				flag = false;
			}else if(alpabet[j]==max){
				flag = true;
			}
		}
		if(!flag) {
			return (char)(index+65);
		}
		return answer;
	}

}
