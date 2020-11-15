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
			long answer = 0; //계산하다가 폭발하는 경우가 있어 long형으로 answer
			int mem=0;
			int count=0;
			
			for(int i=0; i<wordLength; i++) {
				ch = line.charAt(i);
				if(48<=ch && ch<=57) { //숫자0~9까지만 찾아야하므로 ASCII code가 48~57사이인것 찾기
					mem = (mem*10) + ((int)ch -48); //기존에 있던 값에서 *10(일의 자리 확보위해)후에 일의자리 더함
					count++; //숫자가 6자리가 넘의면 히든 넘버가 아니므로 count 갱신
				}else {
					if(count<7) { //7자리 이상인 경우 제외를 위해 
						answer += mem;	
					}
					mem=0;
					count=0;
				}
				if(i==wordLength-1 && mem!=0 &&count<7) { //마지막이 숫자로 끝나는 경우 잡기 위해
 					answer += mem;	
				}
			}
			
			System.out.println(answer);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
    }

}
