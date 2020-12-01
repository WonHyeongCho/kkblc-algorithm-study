package lsy.stack;

import java.util.Arrays;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * */
public class QuizStock {
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int now;
        int result;
        for(int i=0;i<prices.length;i++) {
        	now = prices[i];
        	result = 0;
        	for(int j=i+1;j<prices.length;j++) {
        		result++;
        		if(now>prices[j]) {
        			break;
        		}
        	}
        	answer[i] = result;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		QuizStock q = new QuizStock();
		int[] arr= q.solution(new int[] {1,2,3,2,3});
		System.out.println(Arrays.toString(arr));
	}

}
