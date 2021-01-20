/*
* 주식가격 문제
* https://programmers.co.kr/learn/courses/30/lessons/42584
* *//*


import java.util.*;

public class StockValue {

//    public int[] solution(int[] prices) {
//       int [] answer = new int[prices.length];
//       Stack<Stock> stack = new Stack<>();
//
//       for(int i=0;i<prices.length;i++){
//           int price = prices[i];
//           if(!stack.isEmpty()){
//               while (!stack.isEmpty() && stack.peek().price > price){
//                   Stock st = stack.pop();
//                   answer[st.time -1] = i+1 - st.time;
//               }
//               stack.push(new Stock(price, i+1));
//           }else{
//               stack.push((new Stock(price,i+1)));
//           }
//       }
//       while (!stack.isEmpty()){
//           Stock st = stack.pop();
//           answer[st.time -1] = prices.length -st.time;
//       }
//        System.out.println(Arrays.toString(answer));
//        return answer;
//
//    }
//
//    class Stock {
//
//        int price, time;
//        public Stock(int price, int time){
//            this.price = price;
//            this.time = time;
//        }
//    }
public int[] solution(int[] prices) {
    Stack<Integer> beginIdxs = new Stack<>();
    int i=0;
    int[] terms = new int[prices.length];

    beginIdxs.push(i);
    for (i=1; i<prices.length; i++) {
                !stack.isEmpty() && stack.peek().price > price
        while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx;
        }
        beginIdxs.push(i);
    }
    while (!beginIdxs.empty()) {
        int beginIdx = beginIdxs.pop();
        terms[beginIdx] = i - beginIdx - 1;
    }

    return terms;
}


    public static void main(String[] args) {
        StockValue bts = new StockValue();
        int [] prices = {1, 2, 3, 2, 3};
        bts.solution(prices);
    }
}
*/
