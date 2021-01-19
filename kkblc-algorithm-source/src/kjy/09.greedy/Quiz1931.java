import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Quiz1931 {
	/*
	 * 출처: https://www.acmicpc.net/problem/1931
	 * 풀이: 회의 시작시간 기준으로 정렬해서 풀려니까 잘 안됐음.
	 *      인터넷 찾아보니 종료시간 기준으로 한다는 아이디어가 있어서 그렇게 풀어보기로함.
	 * 		회의 종료시간이 같다면, 시작시간이 더 빠른회의선택(겹치지않는애들중에서)
	 */
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Meeting> list = new ArrayList<>();
		N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.add(new Meeting(start,end));
		}
		
		Collections.sort(list);
		
		int start = 0, cnt = 0;
		for(int i=0; i<list.size(); i++) {
			if(start<=list.get(i).getStart()) {
				cnt++;
				start = list.get(i).getEnd();
			}
			//System.out.println("start: "+list.get(i).getStart()+", end: "+list.get(i).getEnd());
		}
		
		System.out.println(cnt);
	}

}
class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	
	public Meeting() {
		;
	}
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	@Override
	public int compareTo(Meeting m) {
		if(end==m.getEnd()) {
			return start-m.getStart(); //종료시간이 같을경우 start - 비교대상start
		}else {	//종료시간이 다를경우 end - 비교대상end
			return end-m.getEnd();
		}
	}
}