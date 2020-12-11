package lsy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Quize1697 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			br.close();
			
			
			ArrayDeque<Integer> parents = new ArrayDeque<Integer>();
			ArrayDeque<Integer> temp = new ArrayDeque<Integer>();
			boolean[] visited = new boolean[3000000];
			
			parents.add(N);
			visited[N] = true;
			
			int answer = 0;
			
			
			boolean flag = true;
			int now;
			while(flag) {
				while(parents.isEmpty()) {
					now= parents.poll();
					//System.out.println(now);
					if(now == K) {
						flag = false;
						break;
					}else {
						if(check(now-1,visited)) {
							temp.add(now-1);
							visited[now-1] = true;
						}
						if(check(now+1,visited)) {
							temp.add(now+1);
							visited[now+1] = true;
						}
						if(check(now*2,visited)) {
							temp.add(now*2);
							visited[now*2] = true;
						}
					}
				}
				if(!flag) {
					break;
				}else {
					answer++;
				}
				while(!temp.isEmpty()) {
					now = temp.poll();
					//System.out.println(" : "+now);
					if(now==K) {
						flag = false;
						break;
					}else {
						if(check(now-1,visited)) {
							parents.add(now-1);
							visited[now-1] = true;
						}
						if(check(now+1,visited)) {
							parents.add(now+1);
							visited[now+1] = true;
						}
						if(check(now*2,visited)) {
							parents.add(now*2);
							visited[now*2] = true;
						}
					}
				}
				if(!flag) {
					break;
				}else {
					answer++;
				}
			}
			
			
			System.out.println(answer);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	public static boolean check(int num, boolean[] visited) {
		if(num<0 || num > 1500000) {
			return false;
		}else {
			return !visited[num];
		}
	}
}
