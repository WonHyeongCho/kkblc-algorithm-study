import java.util.ArrayList;
import java.util.Scanner;

public class Quiz15649 {
    /*
     * 출처: https://www.acmicpc.net/problem/15649
     */
	public static boolean[] visited;
	public static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N+1];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			list.add(i);
			backtracking(list);
			list.remove(list.size()-1);
			visited[i] = false;
		}
		
	}
	
	public static void backtracking(ArrayList<Integer> list) {
		if(list.size()==M) { //M개를 모두 출력했을경우 끝
			for(int i=0; i<list.size(); i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) { //유망하다면 탐색
				visited[i] = true;
				list.add(i);
				backtracking(list);
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
		
	}
}
