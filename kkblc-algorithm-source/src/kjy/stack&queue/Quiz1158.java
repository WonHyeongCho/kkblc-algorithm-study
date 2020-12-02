import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Quiz1158 {
	/*
	 백준1158: https://www.acmicpc.net/problem/1158
	 1부터 N번까지의 사람이 앉아있을때, K번째 사람을 계속해서 제거한다고 가정한다.
	 이때 순열을 요세푸스 순열이라고 한다.
	 
	 큐를 사용해서 1~K-1까지는 계속해서 뽑고, 다시 넣어주고 K번째수는 그냥 제거하면서 순열에 저장해주면 되는문제이다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> que = new ArrayDeque<Integer>();
		
		String answer = "<";
		int cnt=0, pick=0;
		cnt = sc.nextInt();
		pick = sc.nextInt();
		
		for(int i=1; i<=cnt; i++) {
			que.add(i);
		}
		
		while(!que.isEmpty()) {
			int num = 0;
			for(int i=1; i<pick; i++) {
				num = que.poll();
				que.add(num);
			}
			answer+=que.poll();
			if(!que.isEmpty()) {
				answer+=", ";
			}
		}
		
		answer+=">";
		System.out.println(answer);
	}
}
