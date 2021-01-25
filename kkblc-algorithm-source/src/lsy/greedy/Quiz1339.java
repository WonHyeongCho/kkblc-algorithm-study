package lsy.greedy;
//https://www.acmicpc.net/problem/1339

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Quiz1339 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Character, Double> map = new HashMap<Character, Double>();
		
		for(int i=0; i<N;i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			String word = sb.reverse().toString();
			for(int j=0; j<word.length();j++) {
				map.put(word.charAt(j), map.getOrDefault(word.charAt(j), (double)0)+Math.pow(10, j)); //값을 계속 누적하여 저장
			}
		}
		List<Character> keySetList = new ArrayList<Character>(map.keySet());
		Collections.sort(keySetList, new Comparator<Character>() {
			@Override
			public int compare(Character c1 , Character c2) {
				return map.get(c2).compareTo(map.get(c1));
			}
		});
		int number = 9;
		int answer= 0;
		for(int i=0; i<keySetList.size(); i++) {
			char key = keySetList.get(i); //큰 값부터 number를 곱하여나감
			answer += map.get(key) *number;
			number--;
		}
		System.out.println(answer);
	}

}
