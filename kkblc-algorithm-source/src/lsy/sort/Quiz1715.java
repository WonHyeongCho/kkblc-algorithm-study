package lsy.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Quiz1715 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> que = new PriorityQueue<Integer>(100000);
			
			for(int i=0; i<N;i++) {
				que.add(Integer.parseInt(br.readLine()));
			}
			if(que.size()==1) {
				System.out.println(0);
			}else {
				long answer = solution(que);
				System.out.print(answer);	
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static long solution(Queue<Integer> que) {
		long answer = 0;
		int first, second;
		int sum;
		while(que.size()!=1) {
			first = que.poll();
			second = que.poll();
			sum = first+ second;
			answer+=sum;
			que.add(sum);
		}
		return answer;
	}

}
