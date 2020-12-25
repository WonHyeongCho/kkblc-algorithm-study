package lsy.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Quiz16236 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			Node start = null;
			//북,서,동,남
			int[] dx = {-1, 0, 0, 1};
			int[] dy = {0, -1, 1, 0};
			
			StringTokenizer st;
			int j, value;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				j=0;
				while(st.hasMoreTokens()) {
					value = Integer.parseInt(st.nextToken());
					if(value == 9) {
						start = new Node(i,j);
						map[i][j++] = 0;
					}else {
						map[i][j++] = value; 
					}
					
				}
			}
			br.close();
			
			//방문여부 체크를 위한 set
			HashSet<Node> visited = new HashSet<Node>();
			Queue<Node> que = new ArrayDeque<Node>();
			
			que.add(start);
			visited.add(start);
			
			//이동 횟수 카운트 --> 먹이 먹고 난후 부터 다음 먹이까지
			int count=1;
			//답
			int answer=0;
			//상어크기
			int sharkSize= 2;
			//상어가 먹은 먹이
			int bulkUp =0;
			//큐 크기만큼 반복하기 위해
			int queSize;
			//찐 다음 노드 확인위해
			Node realNextNode = null;
			
			while(!que.isEmpty()) {
				queSize = que.size();
				Node now;
				int nextX, nextY;
				realNextNode = null;
				for(int i=0; i< queSize ; i++) {
					now = que.poll();
					//북,동,서,남 순으로 탐색 수행
					for(int k=0; k<dx.length;k++) {
						nextX = now.x + dx[k];
						nextY = now.y + dy[k];
						//boundary check 
						if(nextX>=0 && nextX <N && nextY >=0 && nextY < N ) {
							//상어 크기 보다 작거나 같은지
							if(map[nextX][nextY] <= sharkSize) {
								Node newNode = new Node(nextX, nextY);
								//지나가여~
								if(map[nextX][nextY] == sharkSize || map[nextX][nextY] ==0) {
									if(!visited.contains(newNode)) {
										que.add(newNode);
										visited.add(newNode);
									}
								//먹이 냠냠
								}else {
									//먹이 후보 없으면 이 노드가 찐 노드
									if(realNextNode==null) {
										realNextNode = newNode;
									//먹이 후보 있으면 북쪽, 동쪽에 가까운 친구가 정답임
									}else {
										if(realNextNode.x > newNode.x) {
											realNextNode = newNode;
										}else if(realNextNode.x == newNode.x){
											if(realNextNode.y > newNode.y) {
												realNextNode = newNode;
											}
										}
									}
									
								}
								
							}
						}
					}
				}
				if(realNextNode != null) {
					//그 지점부터 다시 시작해
					visited.clear();
					//먹이 없애
					map[realNextNode.x][realNextNode.y] = 0;
					//que는 비워
					que.clear();
					
					//벌크업 셋팅
					bulkUp++;
					if(bulkUp == sharkSize) {
						sharkSize++;
						bulkUp=0;
					}
					//answer 갱신
					answer += count;
					count= 0;
					
					visited.add(realNextNode);
					que.add(realNextNode);
				}
				count++;
			}
			System.out.println(answer);
			
			
		}catch(IOException e) {
			
		}
	}
	public static class Node{
		int x;
		int y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object other) {
			if(other instanceof Node) {
				Node otherNode = (Node)other;
				if(otherNode.x ==this.x && otherNode.y== this.y) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			int prime = 31;
			int result = 1;
			result = prime* result + x;
			result = prime* result + y;
			return result;
		}
		
		@Override
		public String toString() {
			return x + " : " + y;
		}
	}

}
