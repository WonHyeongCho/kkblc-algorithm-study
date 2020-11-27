import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 * 2주차(정렬, 탐색)
 *  바이러스: https://www.acmicpc.net/problem/2606
 *  visited[] : 방문여부체크
 *  map[][] : 연결되어있다면 true, 아니면 false
 *  
 *  que에 처음에 1을 넣는다.
 *  que에 있는값 하나를 빼고, 해당값의 번호를 갖틑 컴퓨터와 인접해있는 컴퓨터를 다 넣어주면서 vistied[i] = true, answer++ 처리해준다.
 *  que가 완전히 빌때가지 계속반복
 *  
 */
public class Quiz2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> que = new ArrayDeque<>();
		
		int comCnt = sc.nextInt();
		int netCnt = sc.nextInt();
		int answer = 0;
		
		boolean[][] map = new boolean[comCnt+1][comCnt+1];
		boolean[] visited = new boolean[comCnt+1];
		
		for(int i=0; i<netCnt; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			map[num1][num2] = map[num2][num1] = true;
		}
		
		que.add(1);
		visited[1] = true;
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			for(int i=1; i<= comCnt; i++) {
				if(map[num][i]) {
					if(!visited[i]) {
						que.add(i);
						visited[i] = true; 
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
