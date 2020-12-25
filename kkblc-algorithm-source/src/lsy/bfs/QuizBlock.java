package lsy.bfs;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/60063
 * */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class QuizBlock {
	public int solution(int[][] board) {
        int answer = 0;
        Queue<Location> que = new LinkedList<Location>();
        HashSet<Location> visited = new HashSet<Location>();
        
        int N = board.length;
        
        Location first = new Location(0,0,0,1,0);
        
        visited.add(first);
        que.add(first);
        
        Location now;
        while(!que.isEmpty()) {
        	now = que.poll();
        	
        	//종료 조건 확인 (두 지점중 하나라도 종점에 도착하면 종료)
        	if((now.first_x ==N-1  && now.first_y==N-1) ||
        			(now.second_x==N-1 && now.second_y==N-1)) {
        		answer = now.value;
        		break;
        	}
        	
        	//가로, 세로 구분을 위한 조건문
        	if(now.first_x==now.second_x) {
        		//가로인경우 탐색 시작 동, 서, 남, 북 순으로 탐색
        		//동
        		int value = now.second_y +1;
        		if(isInBoundary(value,N) && board[now.first_x][value]==0) {
        			check(now.second_x,now.second_y,now.second_x, value,now.value+1,visited, que);	
        		}
        		//서
        		value = now.first_y -1;
        		if(isInBoundary(value,N) && board[now.first_x][value] ==0) {
        			check(now.first_x, value, now.first_x, now.first_y,now.value+1,visited, que);
        		}
        		//남
        		value = now.first_x+1;
        		if(isInBoundary(value,N) && board[value][now.first_y]==0 &&board[value][now.second_y]==0) {
        			check(value, now.first_y,value , now.second_y,now.value+1,visited, que);	
        			check(now.first_x, now.first_y, value, now.first_y ,now.value+1, visited, que);	
        			check(now.second_x, now.second_y, value, now.second_y,now.value+1,visited, que);
        		}
        		//북
        		value = now.first_x-1;
        		if(isInBoundary(value,N) && board[value][now.first_y]==0&& board[value][now.second_y]==0) {
        			check(value, now.first_y, value, now.second_y,now.value+1,visited, que);
        			check(value, now.first_y, now.first_x, now.first_y,now.value+1,visited, que);	
        			check(value, now.second_y, now.second_x, now.second_y,now.value+1,visited, que);
        		}
        		
        	}else {
        		//세로
        		//동
        		int value = now.first_y+1;
        		if(isInBoundary(value,N) && board[now.first_x][value]==0 &&board[now.second_x][value]==0) {
        			check(now.first_x, value, now.second_x, value, now.value+1,visited, que);
        			check(now.first_x, now.first_y, now.first_x, value, now.value+1,visited, que);
        			check(now.second_x, now.second_y, now.second_x, value, now.value+1,visited, que);
        		}
        		//서
        		value = now.first_y-1;
        		if(isInBoundary(value,N) && board[now.first_x][value]==0 && board[now.second_x][value]==0) {
        			check(now.first_x, value, now.second_x, value, now.value+1,visited, que);
        			check(now.first_x,value,now.first_x, now.first_y, now.value+1,visited, que);
        			check(now.second_x, value, now.second_x, now.second_y, now.value+1,visited, que);
        		}
        		//남
        		value = now.second_x+1;
        		if(isInBoundary(value,N) && board[value][now.first_y]==0) {
        			check(now.second_x, now.second_y, value, now.second_y, now.value+1,visited, que);
        		}
        		//북
        		value = now.first_x-1;
        		if(isInBoundary(value,N) && board[value][now.first_y]==0) {
        			check(value, now.first_y, now.first_x, now.first_y, now.value+1,visited, que);
        		}
        	}
        }
        
        return answer;
    }
	
	public void check(int first_x, int first_y, int second_x, int second_y, int value,
			HashSet<Location> visited, Queue<Location> que) {
		//다음 위치의 로봇
		Location next = new Location(first_x, first_y, second_x, second_y,value);
		//해당 위치 방문 여부 체크
		if(!visited.contains(next)) {
			//방문한적 없으면 방문 목록에 추가
			visited.add(next);
			//다음 실행을 위헤.. 큐에 추가
			que.add(next);
		}
	}
	
	//박스안에 들어오는지 확인 위한 메소드
	public boolean isInBoundary(int value, int N) {
		if(value>=0 && value <N) return true;
		return false;
	}

	
	//로봇의 위치를 담은 클래스
	class Location{
		int first_x;
		int first_y;
		int second_x;
		int second_y;
		
		int value;
		
		public Location(int first, int first_y, int second, int second_y, int value) {
			this.first_x = first;
			this.first_y = first_y;
			this.second_x = second;
			this.second_y = second_y;
			this.value  = value;
		}
		
		@Override
		public boolean equals(Object other) {
			if(!(other instanceof Location)) {
				return false;
			}
			Location otherLocation = (Location)other;
			//정점 두개가 모두 동일할 경우 같은 Location
			if(otherLocation.first_x==this.first_x
					&& otherLocation.first_y == this.first_y) {
				if(otherLocation.second_x == this.second_x
						&& otherLocation.second_y == this.second_y) {
					return true;
				}
			}
			if(otherLocation.first_x==this.second_x
					&& otherLocation.first_y == this.second_y) {
				if(otherLocation.second_x == this.first_x
						&& otherLocation.second_y == this.first_y) {
					return true;
				}
			}
			
			return false;
		}
		
		@Override
		public String toString() {
			return this.first_x + " : " + 
		this.first_y + " / " + this.second_x + " : "+ this.second_y + " //////     "  + this.value;
		}
		
		@Override
		public int hashCode() {
			final int prime =31;
			int result = 1;
			result = prime * result +  first_x;
			result = prime * result + first_y;
			result = prime * result + second_x;
			result = prime * result + second_y;
			return result;
		}
	}
	
	public static void main(String[] args) {
		QuizBlock q = new QuizBlock();
		int result = q.solution(new int[][] {{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}});
		System.out.println(result);
	}
}
