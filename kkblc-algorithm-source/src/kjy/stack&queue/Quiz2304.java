import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Quiz2304 {
	/*
	 * 백준2304: https://www.acmicpc.net/problem/2304
	 * 
	 * 기준 기둥(최대높이)을 중심으로 왼쪽, 오른쪽으로 나눠서 더해준다(stack을 사용해 현재기둥높이와 비교하면서 더함) 맨 왼쪽부터
	 * 기준기둥까지 계단식으로 올라가면서 더해준다.(오목한부분이 있으면 안되기때문) 맨 오른쪽부터 기준기둥까지 계단식으로 올라가면서 더해준다.
	 */
	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		Scanner sc = new Scanner(System.in);
		int maxHeight=0, maxIndex=0, start=1001, end=0, cnt=0, answer=0;
		int[] numArray;
		
		cnt = sc.nextInt();
		numArray = new int[1001];
		
		for(int i=0; i<cnt; i++) {
			int index = sc.nextInt();
			int height = sc.nextInt();
			
			numArray[index] = height;
			if(height>maxHeight) {
				maxHeight = height;
				maxIndex = index;
			}
			if(start>index) {
				start = index;
			}
			if(end<index) {
				end = index;
			}
			
		}
		
		
		//왼쪽에서 기준기둥까지(기준 기둥포함)
		stack.push(0);
		
		for(int i=start; i<maxIndex; i++) {
			if(stack.peek()<numArray[i]) {
				stack.pop();
				stack.push(numArray[i]);
			}
			answer+=stack.peek();
			//System.out.println("i = "+i+", answer = "+answer);
		}
		
		//기준기둥더하기
		answer+=maxHeight;
		//System.out.println("answer = "+answer);
		
		while(!stack.isEmpty())
			stack.pop();
		
		//맨오른쪽에서 기준기둥 전까지
		stack.push(0);
		for(int i=end; i>maxIndex; i--) {
			if(stack.peek()<numArray[i]) {
				stack.pop();
				stack.push(numArray[i]);
			}
			answer+=stack.peek();
			//System.out.println("i = "+i+", answer = "+answer);
		}
		
		System.out.println(answer);
	}
}
