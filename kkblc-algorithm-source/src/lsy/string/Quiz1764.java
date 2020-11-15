package lsy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Quiz1764 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			ArrayList<String> answer = new ArrayList<String>(); //답 뱉기
			HashSet<String> set = new HashSet<String>(); //비교 기준
			
			String line = br.readLine(); //N, M 읽어오기
			String[] temp = line.split(" ");
			int N = Integer.parseInt(temp[0]);
			int M = Integer.parseInt(temp[1]);
			
			String now; //readLine 값 가져오기
			for(int i=0;i<N;i++) {
				now = br.readLine();
				set.add(now); //set에 값 추가
			}
			
			for(int j=0;j<M;j++) {
				now = br.readLine();
				if(set.contains(now)) { //M번 만큼 돌면서 set에 있는 데이터인지 확인  && set에 있으면 answer에 추가
					answer.add(now);
				}
			}
			int size = answer.size();
			System.out.println(size);
			//사전에 등록된 순으로 return 하기 위해 sort 수행
			answer.sort(new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					return s1.compareTo(s2);
				}
			});
			
			//정렬된 데이터 return
			for(int i=0; i<size;i++) {
				System.out.println(answer.get(i));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
