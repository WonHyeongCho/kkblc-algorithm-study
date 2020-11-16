package lsy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Quiz1152 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(scan.nextLine());
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
