package lsy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 링크: https://www.acmicpc.net/problem/8595
 * 제목: 히든 넘버
 */

public class Quiz8595 {
    public static void main(String[] args) {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int wordLength = Integer.parseInt(br.readLine());
			String line = br.readLine();
			char ch ;
			long answer = 0;
			int mem=0;
			int count=0;
			
			for(int i=0; i<wordLength; i++) {
				ch = line.charAt(i);
				if(48<=ch && ch<=57) {
					mem = (mem*10) + ((int)ch -48); 
					count++;
				}else {
					if(count<7) {
						answer += mem;	
					}
					mem=0;
					count=0;
				}
				if(i==wordLength-1 && mem!=0 &&count<7) {
					answer += mem;	
				}
			}
			
			System.out.println(answer);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

}
