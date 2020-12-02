/*
* 주식가격 문제
* https://programmers.co.kr/learn/courses/30/lessons/42584
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StockValue {

    public int[] solution(int[] prices) {
        int len = prices.length;
        int [] answer = new int [len];

        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> lists = new ArrayList<Integer>();
        //array는 길이가 정해져있다.

        for(int i=1;i<prices.length;i++){

            while(!stack.empty() && prices[i] < prices[stack.peek()]){
                int startIdx = stack.pop();
                answer[startIdx] = i - startIdx;
            }
            stack.push(i);
        }

        while (!stack.empty()){
            int startIdx = stack.pop();
            answer[startIdx] = i - startIdx-1;
        }


        answer = Arrays.asList(lists);




        return answer;
    }

    public static void main(String[] args) {

        StockValue bts = new StockValue();
        int [] prices = {1, 2, 3, 2, 3};
        bts.solution(prices);

    }
}
