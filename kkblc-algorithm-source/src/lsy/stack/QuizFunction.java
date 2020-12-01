package lsy.stack;
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class QuizFunction {
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int mok, remain;
        for(int i=0; i<progresses.length;i++) {
        	mok = (100-progresses[i])/speeds[i];
        	remain = (100-progresses[i])%speeds[i];
        	if(remain!=0) {
        		mok++;
        	}
        	que.add(mok);
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int now;
        int count;
        while(!que.isEmpty()) {
        	now = que.poll();
        	count = 1;
        	while(!que.isEmpty() && now >= que.peek()) {
        		que.poll();
        		count++;
        	}
        	list.add(count);
        }
        answer = list.stream().mapToInt(v -> v).toArray();
        return answer;
    }
	public static void main(String[] args) {
		QuizFunction q = new QuizFunction();
		int[] ans = q.solution(new int[] {95,90,99,99,80,99}, new int[] {1,1,1,1,1,1});
		System.out.println(Arrays.toString(ans));
	}

}
