package algorithm;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
/*
 	Quiz7576 : https://www.acmicpc.net/problem/7576
 */
public class Quiz7576 {
	public static int[][] box;
	public static int M, N;
	public static Deque<Tomato> que;
	public static int moveY[] = {-1,0,1,0};
	public static int moveX[] = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new ArrayDeque<>();
		M = sc.nextInt(); // 가로
		N = sc.nextInt(); // 세로
		box = new int[N][M];
		int curDay = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				box[i][j] = sc.nextInt();
				if(box[i][j]==1) { //익은 토마토
					que.add(new Tomato(i,j, curDay));
				}
			}
		}
		
		if(check()) { //이미 다익었으면 0일
			System.out.println(curDay);
			return;
		}
		
		while(!que.isEmpty()) {
			Tomato t = que.poll();
			curDay = t.getDay();
			
			for(int i=0; i<moveY.length; i++) {
				for(int j=0; j<moveX.length; j++) {
					//1. 범위를 벗어난 경우 제외
					//2. 0이 아닌경우 제외
					int nextY = t.getY() + moveY[i];
					int nextX = t.getX() + moveX[i];
					if(nextY>=N||nextY<0||nextX>=M||nextX<0) 
						continue;
					if(box[nextY][nextX]!=0) 
						continue;
					box[nextY][nextX] = 1; //토마토 익음
					que.add(new Tomato(nextY, nextX, curDay+1)); //큐에 넣어주면서 day++
				}
			}
			
		}
		if(!check()) {
			System.out.println(-1);
		}else {
			System.out.println(curDay);
		}
		
	}
	
	public static boolean check() {
		boolean flag = true;
	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==0) {
					flag = false;
					return flag;
				}
			}
		}
		return flag;
	}

}
class Tomato{
	int y;
	int x;
	int day;
	public Tomato() {
		;
	}
	public Tomato(int y, int x, int day) {
		this.y = y;
		this.x = x;
		this.day = day;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}
