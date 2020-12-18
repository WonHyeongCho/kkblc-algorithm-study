import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 2주차(정렬, 탐색)
 * https://www.acmicpc.net/problem/1715
 * 크기순으로 sorting하고
 * 앞에서부터 2개씩 더해주면되지않을까
 *  ->우선순위큐 사용하는것으로 변경
 *  1 3 4 7 9
 *  4 4 7 9 / 4
 *  8 7 9 / 12
 *  15 9 / 27
 *  24 / 51
*/
public class Quiz1917 {
	static int cnt = 0;
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> que = new PriorityQueue<>();
		Scanner sc = new Scanner(System.in);
		cnt = sc.nextInt();
		int sum = 0;
		
		for(int i=0; i<cnt; i++) {
			int num = sc.nextInt();
			que.add(num);
		}
		
		if(cnt==1) {
			System.out.println(0);
			return;
		}
		
		while(!que.isEmpty()) {
			int num1 = que.poll();
			int num2 = que.poll();
			sum+=(num1+num2);
			
			if(que.isEmpty()) {
				break;
			}
			
			que.add(num1+num2);
		}
		
		System.out.println(sum);
	}
}
