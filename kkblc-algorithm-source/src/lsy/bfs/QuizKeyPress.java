package lsy.bfs;
//https://programmers.co.kr/learn/courses/30/lessons/67256
//bfs이용한 문제. 다른 문제와 차이점이 있다면 hand 가 오/왼 두개라서 bfs 통해 탐색할때 두번 해야한단점
//숫자가 작아서 시간초과는 안난것같은데, 오/왼 탐색하다가 limit 도달시 return 하는 것이 좋을 듯

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;


public class QuizKeyPress {
	public static final int HASHTAG = -1;
	public static final int STAR = -2;
	
	public String solution(int[] numbers, String hand) {
        String answer = "";
        //오/왼 만 갈수있는 영역 셋팅
        HashSet<Integer> leftOnly = new HashSet<Integer>();
        leftOnly.add(1);
        leftOnly.add(4);
        leftOnly.add(7);
        HashSet<Integer> rightOnly = new HashSet<Integer>();
        rightOnly.add(3);
        rightOnly.add(6);
        rightOnly.add(9);
        
        
        //map 셋팅
        int[][] map = new int[4][3];
        int value = 1;
        for(int i=0;i<3;i++) {
        	for(int j=0;j<3;j++) {
        		map[i][j] = value++; 
        	}
        }
        map[3][0] = STAR;
        map[3][1] = 0;
        map[3][2] = HASHTAG;
        
        
        //답 찾기 시작
        int number; // for문 값 하나
        int left = STAR;
        int right = HASHTAG;
        StringBuilder sb = new StringBuilder();
        
        //bfs 호출시 여러번 생성되므로 처음 만들고 계속 재사용이 효율적이라 판단
        Queue<int[]> que = new ArrayDeque<int[]>();
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        
        //확인 시작
        for(int i=0; i<numbers.length;i++) {
        	number = numbers[i];
        	//왼손만 갈 수 있는 경우
        	if(leftOnly.contains(number)) {
        		sb.append("L");
        		left = number;
        	//오른손만 갈 수 있는 경우
        	}else if(rightOnly.contains(number)) {
        		sb.append("R");
        		right = number;
        	//bfs 이용해서 오/왼 탐색시 얼마나 걸리는지 확인
        	}else {
        		int bfsLeft = bfs(left, map , number, que ,dx, dy);
        		int bfsRight = bfs(right, map, number , que , dx, dy);
        		if(bfsLeft < bfsRight) {
        			left = number;
        			sb.append("L");
        		}else if(bfsLeft == bfsRight) {
        			if(hand.equals("left")) {
        				left = number;
        				sb.append("L");
        			}else {
        				right = number;
        				sb.append("R");
        			}
        		}else {
        			right = number;
        			sb.append("R");
        		}
        	}
        }
        answer = sb.toString();
        return answer;
    }
	public int bfs(int start, int[][] map, int findNum, Queue<int[]> que, 
			int[] dx , int[] dy) {
		
		if(start == findNum) return 0;
		int answer=0;
		int[] startLocation = findLocation(start);
		que.clear();
		//visited 는 초기화가 귀찮아서 계속 생성해줌
		boolean[][] visited = new boolean[4][3];
		que.add(startLocation);
		visited[startLocation[0]][startLocation[1]] = true;
		int nextX, nextY;
		int queSize ;
		while(!que.isEmpty()) {
			queSize = que.size();
			
			for(int j=0; j< queSize ;j++) {
				int[] now = que.poll();
				for(int i=0;i< dx.length;i++) {
					nextX = now[0] + dx[i];
					nextY = now[1] + dy[i];
					if(nextX >= 0 && nextX <4 && nextY >=0 && nextY <3) {
						if(!visited[nextX][nextY]) {
							if(map[nextX][nextY] == findNum) return answer+1;
							que.add(new int[] {nextX, nextY});
							visited[nextX][nextY] = true;
						}
					}
				}	
			}
			
			answer++;
			
		}
		
		return answer;
	}
	
	public int[] findLocation(int number) {
		int[] answer = new int[2];
		if(number == HASHTAG) {
			answer[0] = 3;
			answer[1]= 2;
			return answer;
		}else if(number == STAR) {
			answer[0] = 3;
			answer[1] = 0;
			return answer;
		}else if(number == 0) {
			answer[0] = 3;
			answer[1] = 1;
			return answer;
		}
		if(number % 3 == 0) {
			answer[0] = number/3 -1;
			answer[1] = 2;
		}else {
			answer[0] = number/3;
			answer[1] = number % 3 -1;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		QuizKeyPress q = new QuizKeyPress();
		String ans = q.solution(new int[] {2,2}, "right");
		System.out.println(ans);
	}
}
