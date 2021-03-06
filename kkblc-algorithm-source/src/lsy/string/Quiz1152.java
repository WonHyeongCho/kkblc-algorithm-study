package lsy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Quiz1152 {
//https://www.acmicpc.net/problem/1152
//단어의 갯수
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			int answer = solution(input.trim()); //앞뒤 공백 제거하고 parameter 넘겨줌
			System.out.println(answer);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static int solution(String line) {
		int answer= 0 ;
		if(line.length()==0) {//공백만 들어왔거나 크기가 없는애들 0으로 return
			return answer;
		}
		String[] strArr = line.split(" "); //하나 이상의 문자가 있는 경우 split 으로 분해
		answer = strArr.length; //그 길이 만큼 return
		return answer;
	}
	

}
