package lsy.dfs;

//https://programmers.co.kr/learn/courses/30/lessons/43165

import java.util.LinkedList;
import java.util.Queue;

public class QuizTargetNumber {
	Queue<Integer> que;
	
	public int solution(int[] numbers, int target) {
        int answer = 0;
        que = new LinkedList<Integer>();
        que.add(numbers[0]);
        que.add(-numbers[0]);
        for(int i=1;i<numbers.length;i++) {
        	check(numbers[i]);
        }
        while(!que.isEmpty()) {
        	if(que.poll().equals(target)) {
        		answer++;
        	}
        }
        return answer;
    }
	
	public void check(int number) {
		int size = que.size();
		int temp;
		for(int i=0;i<size;i++) {
			temp = que.poll();
			que.add(temp+number);
			que.add(temp-number);
		}
	}
	
	public static void main(String[] args) {
		QuizTargetNumber q = new QuizTargetNumber();
		int answer= q.solution(new int[] {1,1,1,1,1}, 3);
		System.out.println(answer);
	}

}
