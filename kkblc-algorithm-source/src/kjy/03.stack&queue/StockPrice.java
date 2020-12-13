import java.util.Stack;

public class StockPrice {
	
	public static int[] solution(int[] prices)  {
		int[] answers = new int[prices.length];
		Stack<StockInfo> stack = new Stack<>();
		StockInfo curInfo;
		
		for(int i=0; i<prices.length; i++) {
			//stack이 비어있지않고, stack의 top의 가격과 현재가격을 비교했을때, stack에 있는 가격이 더 클경우
			//stack에서 빼고, answer[top.time] = i(현재시간) - top.time
			while(!stack.isEmpty() && stack.peek().getPrice() > prices[i]) {
				curInfo = stack.pop();
				answers[curInfo.getTime()] = i - curInfo.getTime();
			}
			stack.push(new StockInfo(i, prices[i]));
		}
		
		while(!stack.isEmpty()) {
			curInfo = stack.pop();
			answers[curInfo.getTime()] = prices.length-1-curInfo.getTime();
		}
		
		return answers;
	}
	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		
		int[] answer = solution(prices);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
		
	}
	 
}
class StockInfo{
	int time;
	int price;
	
	public StockInfo() {
		;
	}
	public StockInfo(int time, int price) {
		this.time = time;
		this.price = price;
	}
	public int getTime() {
		return time;
	}
	public int getPrice() {
		return price;
	}
}
