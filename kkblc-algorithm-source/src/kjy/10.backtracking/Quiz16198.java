import java.util.ArrayList;
import java.util.Scanner;

public class Quiz16198 {
    static int N, answer=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		N = sc.nextInt();
		
		for(int i=0; i<N; i++)
			list.add(sc.nextInt());
		
		solve(list, 0);
		
		System.out.println(answer);
	}
	public static void solve(ArrayList<Integer> numList, int sum) {
		//종료조건(양끝에 두개의 수만 남은경우) max값계산
		if(numList.size()<=2) {
			if(sum>answer) {
				answer = sum;
			}
			return;
		}
		
		for(int i=1; i<numList.size()-1; i++) {
			int curNum = numList.get(i);
			int curSum = sum+(numList.get(i-1)*numList.get(i+1));
			numList.remove(i);
			solve(numList, curSum);
			numList.add(i, curNum);
		}
	}
} 
